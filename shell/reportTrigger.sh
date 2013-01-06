#!/bin/sh
#Program:
#       This is program which will call the server side to generate the sonar violation change report
#History:
#       2012 June
#

echo "groupId:             " $groupId
echo "artifactId:          " $artifactId
echo "period:              " $period
echo "violationPriority:   " $violationPriority
echo "async:               " $async
echo "AdditionalRecipients:" $AdditionalRecipients

if [ -z $groupId ] || [ -z $artifactId ]; then
  echo "Mandatory parameter is required";
  exit 1;
fi

if [ -z "$PARAMETER" ]; then
  PARAMETER="groupId=$groupId&artifactId=$artifactId"
else
  PARAMETER=$PARAMETER"groupId=$groupId&artifactId=$artifactId"
fi

case $period in
  "N/A")
	;;
  "SincePreviousAnalysis")
	PARAMETER="$PARAMETER&period=1"
	;;
  "Over5Days")
	PARAMETER="$PARAMETER&period=2"
	;;
  "Over30Days")
	PARAMETER="$PARAMETER&period=3"
	;;
  *)
	;;
esac

case $violationPriority in
  "N/A")
	;;
  "BLOCKER")
	PARAMETER="$PARAMETER&violationPriority=BLOCKER"
	;;
  "CRITICAL")
	PARAMETER="$PARAMETER&violationPriority=CRITICAL"
	;;
  "MAJOR")
	PARAMETER="$PARAMETER&violationPriority=MAJOR"
	;;
  "MINOR")
	PARAMETER="$PARAMETER&violationPriority=MINOR"
	;;
  "INFO")
	PARAMETER="$PARAMETER&violationPriority=INFO"
	;;
  *)
	;;
esac

case $async in
  "N/A")
	;;
  "true")
	PARAMETER="$PARAMETER&async=true"
	;;
  "false")
	PARAMETER="$PARAMETER&async=false"
	;;
  *)
	;;
esac

if [ -n "$AdditionalRecipients" ]; then
  PARAMETER=$PARAMETER"&AdditionalRecipients=$AdditionalRecipients"
fi

if [ -z "$ReportInstance" ]; then 
  ReportInstance="http://fms-wookong.asiapacific.hpqcorp.net:8080/QualityOne"
fi

echo "the request parmeters is:   $PARAMETER"
echo "report instance is $ReportInstance    "

curl --connect-timeout 1200 -d $PARAMETER $ReportInstance/SonarViolationChangeReport
