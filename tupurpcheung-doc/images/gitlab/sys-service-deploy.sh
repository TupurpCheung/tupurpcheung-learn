#!/bin/sh
#发布最新代码
PROVIDER_PATH=/usr/local/workspace/sys-service
CUSTOMTER_PATH=/usr/local/tomcat/tomcat8-2

#停止生产者，删除旧的生产者
echo -e "\033[42;37m ---------即将部署最新环境------- \033[0m"
echo -e "\033[42;37m ####生产者相关操作： \033[0m"
echo -e "\033[42;37m ####停止生产者： \033[0m"

${PROVIDER_PATH}/sys-service.sh stop &>/dev/null
PROVIDER_STATE=$?
 
if [ $PROVIDER_STATE -ne 0 ]; then
	echo -e "\033[33m 生产者停止异常 \033[0m"
else
	echo -e "\033[32m 生产者已停止 \033[0m"
fi

echo -e "\033[42;37m ####删除旧的生产者jar文件 \033[0m"
rm -rf ${PROVIDER_PATH}/jsyf-sys-service.jar
RM_STATE=$?
if [ $RM_STATE -ne 0 ]; then
	echo -e "\033[33m 生产者Jar文件不存在 \033[0m"
else
	echo -e "\033[32m 生产者jar文件已删除 \033[0m"
fi

echo -e "\033[42;37m ####删除旧的生产者依赖Lib文件夹 \033[0m"
rm -rf ${PROVIDER_PATH}/lib
RM_STATE=$?
if [ $RM_STATE -ne 0 ]; then
	echo -e "\033[33m 生产者依赖Lib文件夹不存在 \033[0m"
else
	echo -e "\033[32m 生产者依赖Lib文件夹已删除 \033[0m"
fi

#复制生产者和依赖的jar包
echo -e "\033[42;37m ####复制项目生产者的依赖Lib文件夹 \033[0m"
cd /home/gitlab-runner/builds/5148bab9/0/jsyf/shop/jsyf-sys-service/target/lib &>/dev/null
DIR_EXISTS=$?
if [ $DIR_EXISTS -ne 0 ]; then
	echo -e "\033[31m 生产者依赖Lib文件夹打包失败或丢失，更新失败，自动部署已失败！！！ \033[0m"
	exit 5
else
	cp -r /home/gitlab-runner/builds/5148bab9/0/jsyf/shop/jsyf-sys-service/target/lib ${PROVIDER_PATH}/
	echo -e "\033[32m 生产者依赖Lib文件夹更新成功 \033[0m"
fi

echo -e "\033[42;37m ####复制项目生产者jar文件 \033[0m"
cp /home/gitlab-runner/builds/5148bab9/0/jsyf/shop/jsyf-sys-service/target/jsyf-sys-service.jar ${PROVIDER_PATH}/ &>/dev/null
CP_STATE=$?
if [ $CP_STATE -ne 0 ]; then
	echo -e "\033[31m 生产者jar文件打包失败或丢失，更新失败，自动部署已失败！！！ \033[0m"
	exit 5
else
	echo -e "\033[32m 生产者jar文件夹更新成功 \033[0m"
fi

echo -e "\033[42;37m ####启动生产者 \033[0m"
${PROVIDER_PATH}/sys-service.sh start &>/dev/null
PROVIDER_STATE=$?
 
if [ $PROVIDER_STATE -ne 0 ]; then
	echo -e "\033[33m 生产者启动异常 \033[0m"
	exit 5
else
	echo -e "\033[32m 生产者启动成功 \033[0m"
fi

sleep 3

#更新消费者
echo -e "\033[42;37m ####消费者相关操作 \033[0m"
echo -e "\033[42;37m ####停止消费者： \033[0m"

${CUSTOMTER_PATH}/bin/shutdown.sh &>/dev/null
CONSUME_STATE=$?
if [ $CONSUME_STATE -ne 0 ]; then
	echo -e "\033[31m 消费者停止异常 \033[0m"
	exit 5
else
	echo -e "\033[32m 消费者停止成功 \033[0m"
fi

echo -e "\033[42;37m ####删除旧消费者 \033[0m"
rm -rf ${CUSTOMTER_PATH}/webapps/{jsyf-sys.war,jsyf-sys} &>/dev/null
RM_STATE=$?
if [ $RM_STATE -ne 0 ]; then
	echo -e "\033[33m 消费者相关文件不存在 \033[0m"
else
	echo -e "\033[32m 消费者相关文件已删除 \033[0m"
fi

echo -e "\033[42;37m ####更新消费者 \033[0m"
cp /home/gitlab-runner/builds/5148bab9/0/jsyf/shop/jsyf-sys/target/jsyf-sys.war ${CUSTOMTER_PATH}/webapps &>/dev/null
CP_STATE=$?
if [ $CP_STATE -ne 0 ]; then
	echo -e "\033[33m 消费者相关文件打包失败或丢失，更新失败，自动部署已失败！！！ \033[0m"
	exit 5
else
	echo -e "\033[32m 消费者更新成功 \033[0m"
fi

echo -e "\033[42;37m ####启动消费者 \033[0m"
${CUSTOMTER_PATH}/bin/startup.sh &>/dev/null
CONSUME_STATE=$?
if [ $CONSUME_STATE -ne 0 ]; then
	echo -e "\033[31m 消费者启动异常 \033[0m"
	exit 5
else
	echo -e "\033[32m 消费者启动成功 \033[0m"
fi

exit 0
