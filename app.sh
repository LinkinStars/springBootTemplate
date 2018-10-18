#!/bin/bash

appName=`ls|grep .jar$`
if [ -z $appName ]
then
    echo "Please check that this script and your jar-package is in the same directory!"
    exit 1
fi

killForceFlag=$2

function start()
{
	count=`ps -ef |grep java|grep $appName|wc -l`
	if [ $count != 0 ];then
		echo "Maybe $appName is running, please check it..."
	else
		echo "The $appName is starting..."
		nohup java -XX:+UseG1GC -XX:+HeapDumpOnOutOfMemoryError -Xms512M -Xmx4G -jar $appName > /dev/null 2>&1 &
	fi
}

function stop()
{
	appId=`ps -ef |grep java|grep $appName|awk '{print $2}'`
	if [ -z $appId ]
	then
	    echo "Maybe $appName not running, please check it..."
	else
        echo -n "The $appName is stopping..."
        if [ "$killForceFlag" == "-f" ]
        then 
            echo "by force"
            kill -9 $appId
        else
            echo
	        kill $appId
	    fi
	fi
}

function status()
{
    appId=`ps -ef |grep java|grep $appName|awk '{print $2}'`
	if [ -z $appId ] 
	then
	    echo -e "\033[31m Not running \033[0m" 
	else
	    echo -e "\033[32m Running [$appId] \033[0m" 
	fi
}

function restart()
{
    stop
    for i in {3..1}
    do
        echo -n "$i "
        sleep 1
    done
    echo 0
    start
}

function usage()
{
    echo "Usage: $0 {start|stop|restart|status|stop -f}"
    echo "Example: $0 start"
    exit 1
}

case $1 in
	start)
	start;;

	stop)
	stop;;
	
	restart)
	restart;;
	
	status)
	status;;
	
	*)
	usage;;
esac