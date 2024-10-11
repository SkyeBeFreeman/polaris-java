package com.tencent.polaris.plugins.event.tsf.report;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author jiangfan
 */
public abstract class Event implements Serializable {

    //* 事件类型
    @JsonProperty("type")
    private String event;

    // 事件对象
    @JsonProperty("source")
    private String object;

    // 事件发生时间
    private final long timestamp = System.currentTimeMillis();

    public Event(String source) {
        this.object = source;
    }

    public Event() {
        this.object = "";
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
