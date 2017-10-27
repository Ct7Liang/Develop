# Develop
工具

Step 1. Add the JitPack repository to your build file 
 
 	allprojects {
 		repositories {
 			...
 			maven { url 'https://jitpack.io' }
 		}
 	}
 
 Step 2. Add the dependency
 
 	dependencies {
	         compile 'com.github.Ct7Liang:NewProject:20171027100730'
 	}
   
  
  public class MyApp extends BaseApp {
       @Override
       public String setFolderName() {
           return "NEW_PROJECT";  //文件夹名称
       }
       @Override
       public void initOther() {
 
       }
   }
   
   public abstract class YourBaseActivity extends BaseActivity {
       @Override
       public BaseApp addBaseApp() {
           return MyApp.getAppContext(); //关联MyApp
       }
   
   }
