package com.test.scheduler;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableConfigurationProperties()
@ConfigurationProperties(prefix = "job")
@PropertySource(value={"classpath:/scheduling.properties"})
public class SchedulingProperties {

    private String isExecute;
    private List<String> exeClass;
    private List<String> cronExpression;
    private List<String> description;


    public String getIsExecute() {
        return isExecute;
    }

    public void setIsExecute(String isExecute) {
        this.isExecute = isExecute;
    }

    public List<String> getExeClass() {
        return exeClass;
    }

    public void setExeClass(List<String> exeClass) {
        this.exeClass = exeClass;
    }

    public List<String> getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(List<String> cronExpression) {
        this.cronExpression = cronExpression;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
