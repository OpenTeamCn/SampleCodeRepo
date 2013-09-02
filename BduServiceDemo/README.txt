BAE云服务SDK示例说明

该示例涵盖了BAE的内置服务如：cache, counter, image, rank, socket, fetchurl, taskqueue, mysql, mongodb, redis
通过该示例可以了解内置服务的基本使用

注意：
Config文件位置：/src/com/baidu/cloudservice/conf/Config.java

1. 使用该示例时请您确保开启了cache，mysql，mongodb，redis服务

2. 请将申请的mysql, mongodb, redis,数据库名称填写到Config文件相应的位置处

3. 如果需要使用image服务存储处理以后的图片数据，
	
	(1) 请您确保开启了云存储服务

	(2) 请将云平台管理-->服务管理-->我的密钥中的AK, SK以及云平台管理-->云存储-->我的bucket中的任何一个BUCKET名称填写到
		Config文件相应的位置处（不使用图片服务的请忽略）
	
4. 如果需要使用TaskQueue服务，
	(1)如果需要创建一个POST方式的Fetchurl任务，请将地址和数据填写到Config文件的指定位置。
	   注意：该url必须能够使用post方式上传数据
	
	(2)如果需要使用离线下载任务，请将下载的源地址和上传目的地址填写到Config文件的指定位置。
	   注意：上传的目的地址必须是云存储（BCS）中的地址，请确保开启云存储服务，并将计算好的URL签名作为上传地址
	   URL签名的计算工具：进入应用，点击，云平台管理-->云存储-->URL签名，填写相应的bucket, object名称将生成的put类型的URL签名作为上传地址

5. 将该示例代码通过svn上传至申请的java应用中