package edu.buaa.qjjia.main

import java.io.{ByteArrayOutputStream, File, FileOutputStream}
import java.nio.ByteBuffer
import java.text.SimpleDateFormat
import java.util.Date
import org.apache.avro.Schema
import edu.buaa.qjjia.model.log.{MediaData, RawLog, SvcLog}
import edu.buaa.qjjia.utils.SvcLogAvroUtil
import org.apache.avro.generic.{GenericDatumReader, GenericRecord}
import org.apache.avro.io.{DatumReader, Decoder, DecoderFactory}
import java.util
import net.minidev.json.{JSONObject}
import net.minidev.json.parser.JSONParser
import scala.collection.mutable
import scala.collection.JavaConversions.mutableMapAsJavaMap

/**
  * Created by Administrator on 2016/8/26.
  */
object Test {


  def main(args: Array[String]): Unit = {
    //    val  byteBuffer = ByteBuffer.allocate(256)  //容量为256字节
    val total = Array[Byte](97, 98, 99, 100, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 49, 89, 68)
    val byteBuffer = ByteBuffer.wrap(total)
    //    val descs: List[CharSequence] = List("apples", "oranges", "pears")
    val descs = new util.ArrayList[CharSequence]()
    descs.add("cola")
    descs.add("apples")
    descs.add("oranges")
    descs.add("pears")

    val timestamp = (new Date()).getTime

    //    var colors:Map[CharSequence,CharSequence] = Map()
    //    colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF")

    val extras = new util.HashMap[CharSequence, CharSequence]
    extras.put("red", "#FF0000")
    extras.put("azure", "#F0FFFF")


    val mediaData = new MediaData
    mediaData.setData(byteBuffer)
    mediaData.setType(1)

    val rawLog = new RawLog
    rawLog.setDescs(descs)
    rawLog.setTimestamp(timestamp)
    rawLog.setLevel("001")
    rawLog.setExtras(extras)

    val logs = new util.ArrayList[RawLog]
    logs.add(rawLog)


    val svc = new SvcLog
    svc.setCallName("qjjia")
    svc.setIp(1921681120)
    svc.setLogs(logs)
    svc.setMediaData(mediaData)
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
    println(baos)

    val outName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val outfile = new File("output/demo" + outName + ".avro")
    val fos = new FileOutputStream(outfile)
    fos.write(baos.toByteArray)
    baos.close()
    fos.close()

    val parser: Schema.Parser = new Schema.Parser()
    val schema: Schema = parser.parse(new File("svc.avsc"))

    val record = ReadAvro.deserialize(schema, baos)

    println(record)

    val recordMap = JsonUtil.json2Map(record)

    println(recordMap.get("type"))
    println(recordMap.get("uid"))
    val llogs = recordMap.get("mediaData")
    println(llogs)


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
//        val value = mapAsScalaMap(jsonObj.get(field).asInstanceOf[util.HashMap[String, String]])
        val value = jsonObj.get(field).asInstanceOf[util.HashMap[String, String]]
        map.put(field, value)
      }else {
        map.put(field, value)
      }
    }
    map
  }

}