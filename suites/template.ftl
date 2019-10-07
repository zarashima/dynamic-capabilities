<?xml version="1.0" encoding="UTF-8"?>
<suite name="Sample Test Suite" parallel="tests" verbose="10" thread-count="${threadCount}">
    <#list devicesInformation as device>
        <test name="Tests on ${device.deviceName}" preserve-order="true">
            <parameter name="platformName" value="${device.platformName}"/>
            <parameter name="deviceId" value="${device.deviceId}"/>
            <parameter name="deviceName" value="${device.deviceName}"/>
            <parameter name="deviceVersion" value="${device.deviceVersion}"/>
            <parameter name="systemPort" value="${device.systemPort}"/>
            <classes>
                <class name="sample.SampleTest">
                    <methods>
                        <include name="sampleTest()"/>
                    </methods>
                </class>
            </classes>
        </test>
    </#list>
</suite>
