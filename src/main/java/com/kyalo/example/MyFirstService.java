package com.kyalo.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources(
        {
                @PropertySource("classpath:custom.properties"),
                @PropertySource("classpath:another.properties")
        }
)
public class MyFirstService {

    // Field injection - it is not recommended
//    @Autowired
//    @Qualifier("mySecondClass")
    private MyFirstClass myFirstClass;

    @Value("${my.custom.property}")
    private String customProperty;

    public String getCustomProperty() {
        return customProperty;
    }

    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;

    @Value("${my.last.custom}")
    private String customPropertyFromMultiple;

    public String getCustomPropertyFromMultiple() {
        return customPropertyFromMultiple;
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }
//    private Environment environment;
//
//    @Autowired
//    public void setEnvironment(Environment environment) {
//        this.environment = environment;
//    }
// Method injection
//    @Autowired
//    public void injectDependencies(@Qualifier("myFirstClass") MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }

    // Setter injection
//    @Autowired
//    public void setMyFirstClass(@Qualifier("myThirdClass") MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }


    // Constructor injection
    public MyFirstService(
            @Qualifier("mySecondClass")
            MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }

    public String tellStory(){
        return "the dependency is saying: " + myFirstClass.sayHello();
    }

//    public String getJavaVersion(){
//        return environment.getProperty("java.version");
//    }
//
//    public String getOSName(){
//        return environment.getProperty("os.name");
//    }
//
//    public String getCustomProperty(){
//        return environment.getProperty("my.custom.property");
//    }
}
