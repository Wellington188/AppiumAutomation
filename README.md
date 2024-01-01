## Prerequisites
IDE of your preference;  
Java (last stable version recommended);  
NodeJs (last stable version recommended);  

## Installation - Server

Install the plugin using Appium's plugin CLI, either as a named plugin or via NPM:

```shell
appium plugin install --source=npm appium-gestures-plugin
```

## Activation

The plugin will not be active unless turned on when invoking the Appium server:  
The server must be initialized always before test execution.

```shell
appium --use-plugins=gestures
```
## Info

The tests were executed on a Xiaomi 13 lite Android 13