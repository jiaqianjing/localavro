package edu.buaa.qjjia.main

import java.io.{ByteArrayOutputStream, File, FileOutputStream}
import java.nio.ByteBuffer
import java.text.SimpleDateFormat
import java.util.Date

import org.apache.avro.Schema
import edu.buaa.qjjia.model.log.{MediaData, RawLog, SvcLog}
import org.apache.avro.generic.{GenericDatumReader, GenericRecord}
import org.apache.avro.io.{DatumReader, Decoder, DecoderFactory}
import java.util

import edu.buaa.qjjia.utils.SvcLogAvroUtil
import net.minidev.json.{JSONArray, JSONObject, JSONValue}
import net.minidev.json.parser.JSONParser

import scala.collection.mutable
import scala.collection.JavaConversions.mutableMapAsJavaMap
import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 2016/8/26.
  */
object Test {


  def main(args: Array[String]): Unit = {
    //    val  byteBuffer = ByteBuffer.allocate(256)  //容量为256字节
    val total = Array[Byte](97, 98, 99, 100, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 49, 89, 68)
    val byteBuffer = ByteBuffer.wrap(total)
    //    val descs: List[CharSequence] = List("apples", "oranges", "pears")
    val descs1 = new util.ArrayList[CharSequence]()
    val descs2 = new util.ArrayList[CharSequence]()
    descs1.add("cola")
    descs1.add("apples")
    descs1.add("oranges")
    descs1.add("pears")
    descs2.add("cat")
    descs2.add("dog")
    descs2.add("fish")
    descs2.add("dragon")

    val timestamp = (new Date()).getTime

    //    var colors:Map[CharSequence,CharSequence] = Map()
    //    colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF")

    val extras1 = new util.HashMap[CharSequence, CharSequence]
    val extras2 = new util.HashMap[CharSequence, CharSequence]
    extras1.put("red", "#FF0000")
    extras1.put("azure", "#F0FFFF")

    extras2.put("black", "#000000")
    extras2.put("white", "#FFFFFF")


    val mediaData1 = new MediaData
    val mediaData2 = new MediaData
    mediaData1.setData(byteBuffer)
    mediaData1.setType(1)

    mediaData2.setData(byteBuffer)
    mediaData2.setType(2)

    val rawLog1 = new RawLog
    val rawLog2 = new RawLog
    rawLog1.setDescs(descs1)
    rawLog1.setTimestamp(timestamp)
    rawLog1.setLevel("001")
    rawLog1.setExtras(extras1)

    rawLog2.setDescs(descs2)
    rawLog2.setTimestamp(timestamp)
    rawLog2.setLevel("002")
    rawLog2.setExtras(extras2)


    val logs = new util.ArrayList[RawLog]
    logs.add(rawLog1)
    logs.add(rawLog2)


    val svc = new SvcLog
    svc.setCallName("qjjia")
    svc.setIp(1921681120)
    svc.setLogs(logs)
    svc.setMediaData(mediaData1)
    svc.setSid("atl1921681120")
    svc.setTimestamp(timestamp)
    svc.setType(2)
    svc.setUid("370272561")

    val baos = SvcLogAvroUtil.serialize(svc)

    /**
      * 测试  Demo
      */
    //    val demo = new Demo
    //    demo.setLeft("left")
    //    demo.setRight("right")
    //
    //    val baos = DemoAvroUtil.serialize(demo)
//    println(baos)

    val outName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val outfile = new File("output/demo" + outName + ".avro")
    val fos = new FileOutputStream(outfile)
    fos.write(baos.toByteArray)
    baos.close()
    fos.close()

    val parser: Schema.Parser = new Schema.Parser()
    val schema: Schema = parser.parse(new File("svc.avsc"))

    val record = ReadAvro.deserialize(schema, baos)

//    println(record)

    val recordMap = JsonUtil.json2Map(record)

//    println(recordMap.get("type"))
//    println(recordMap.get("sid"))
//    println(recordMap.get("uid"))
//    println(recordMap.get("timestamp"))
//    println(recordMap.get("ip"))
//    println(recordMap.get("callName"))
//    println(recordMap.get("logs"))
//    println(recordMap.get("mediaData"))


    for (a <- recordMap.get("logs")) {
      // 2 Array
      val aa = JsonUtil.json2Array(a.toString)
      println(aa(1))
      // 2 Json
      val aaa = JsonUtil.array2Json(aa)
      println(aaa)
    }
    for (b <- recordMap.get("mediaData")) {
      // 2 Map
      val bb:mutable.HashMap[String, Object] = JsonUtil.json2Map(b.toString)
      println(bb.get("type"))
      // 2 Json
      val bbb = JsonUtil.map2Json(bb)
      println(bbb)
    }



  }
}

object ReadAvro {

  def deserialize(schema: Schema, baos: ByteArrayOutputStream): String = {
    val reader: DatumReader[GenericRecord] = new GenericDatumReader[GenericRecord](schema)
    val decoder: Decoder = DecoderFactory.get().binaryDecoder(baos.toByteArray(), null)
    val result: GenericRecord = reader.read(null, decoder)
    result.toString
  }


}

object JsonUtil {
  /**
    * 将map转为json
    *
    * @param map 输入格式 mutable.Map[String,Object]
    * @return
    **/
  def map2Json(map: mutable.Map[String, Object]): String = {

    val jsonString = JSONObject.toJSONString(map)

    jsonString
  }

  /**
    * 将json转化为Map
    *
    * @param json 输入json字符串
    * @return
    **/
  def json2Map(json: String): mutable.HashMap[String, Object] = {

    val map: mutable.HashMap[String, Object] = mutable.HashMap()

    val jsonParser = new JSONParser()

    //将string转化为jsonObject
    val jsonObj: JSONObject = jsonParser.parse(json).asInstanceOf[JSONObject]

    //获取所有键
    val jsonKey = jsonObj.keySet()

    val iter = jsonKey.iterator()

    while (iter.hasNext) {
      val field = iter.next()
      val value = jsonObj.get(field).toString

      if (value.startsWith("{") && value.endsWith("}")) {
        //        val value = scala.collection.JavaConversions.mapAsScalaMap(jsonObj.get(field).asInstanceOf[util.HashMap[String, String]])
        val value = jsonObj.get(field).asInstanceOf[util.HashMap[String, String]]
        map.put(field, value)
      } else {
        map.put(field, value)
      }
    }
    map
  }
  /**
    * 将json转化为List
    *
    * @param json 输入json字符串
    * @return
    **/
  def json2Array(json: String): Array[Object] = {

    //将string转化为jsonArray
    val jsonObj: Object = JSONValue.parse(json)
    val array:JSONArray =jsonObj.asInstanceOf[JSONArray]
    array.toArray
  }

  /**
    * 将array转为json
    *
    * @param array
    * @return
    **/
  def array2Json(array: Array[Object]): String = {
    val list = scala.collection.JavaConversions.bufferAsJavaList(array.toBuffer)
    val jsonString = JSONArray.toJSONString(list)
    jsonString
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }

}