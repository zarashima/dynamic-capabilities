## About
To ultilize TestNG [parameters](https://testng.org/doc/documentation-main.html#parameters) in TestNG Test Suite file (.xml) for parallel executions without wasting efforts to handle desired capabilities initializations. See its actual usage in this [repository](https://github.com/zarashima/dynamic-capabilities)

## How does it work
Upon [TestRunner](https://github.com/zarashima/dynamic-capabilities/blob/master/src/test/java/runner/TestRunner.java) execution:
* Dynamic desired capabilities are retrieved using [MobileDeviceInfo](https://github.com/Testinium/MobileDeviceInfo). Applicable for both Android and iOS
* TestNG suite file (.xml) is generated based on the [FreeMaker template](https://github.com/zarashima/dynamic-capabilities/blob/master/suites/template.ftl) through [TestRunner](https://github.com/zarashima/dynamic-capabilities/blob/77e4e8e334e9f38bae40ea4aa599f16e70b4d1b4/src/test/java/TestRunner.java#L27). This template file includes necessary desired capabilities (platformName, systemPort, deviceId, deviceVersion, deviceName) placeholder which are passed from the above step
* TestRunner will execute generated .xml file using its native TestNG runner. This suite is contrusted from the [sample test](https://github.com/zarashima/dynamic-capabilities/blob/master/src/test/java/sample/SampleTest.java)

## Usage
Execute `generateTestSuiteXml` test in [TestRunner](https://github.com/zarashima/dynamic-capabilities/blob/2961b0b37d56a6406a293074ef9bdaf77070ca95/src/test/java/TestRunner.java#L22)

## Usage in your project
Followed this sample project, you will have an approach to resolve your issue with including the dynamic desired capabilites generated from [MobileDeviceInfo](https://github.com/Testinium/MobileDeviceInfo) to be usable in TestSuite file with the help of [FreeMaker](https://freemarker.apache.org/)

## Roadmap
- [ ] Generalize this solution, maybe a maven plugin
- [ ] Add solutions for cloud service providers, such as SauceLabs, BrowserStacks, pCloudy

## Acknowledgement
* [Truth](https://truth.dev/)
* [FreeMaker](https://freemarker.apache.org/)
* [MobileDeviceInfo](https://github.com/Testinium/MobileDeviceInfo/)
