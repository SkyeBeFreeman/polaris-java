package com.tencent.polaris.plugins.event.tsf.report;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author jiangfan
 * @since 0.2.0
 */
public class CloudEvent extends Event {

    // 云上租户 id
    private String appId;

    private String region;

    // 事件状态
    private byte status;

    // 事件唯一标识
    private String id;

    // 事件扩展字段
    @JsonProperty("extensionMsg")
    private Collection<EventAttribute> attributes = new HashSet<>();

    // 事件对象
    private Collection<EventAttribute> dimensions = new HashSet<>();

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<EventAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<EventAttribute> attributes) {
        this.attributes = attributes;
    }

    public void putExtensionMsg(String key, String value) {
        // 如果存在相同 key ，已最后插入的为准
        EventAttribute eventAttribute = new EventAttribute(key, value);
        attributes.remove(eventAttribute);
        attributes.add(eventAttribute);
    }

    public Collection<EventAttribute> getDimensions() {
        return dimensions;
    }

    public void setDimensions(Collection<EventAttribute> dimensions) {
        this.dimensions = dimensions;
    }

    public void putDimension(String key, String value) {
        // 如果存在相同 key ，已最后插入的为准
        EventAttribute eventAttribute = new EventAttribute(key, value);
        dimensions.remove(eventAttribute);
        dimensions.add(eventAttribute);
    }

    public CloudEvent() {
    }

    public CloudEvent(String source) {
        super(source);
    }

    @Override
    public String toString() {
        return "CloudEvent{" +
                "appId='" + appId + '\'' +
                ", region='" + region + '\'' +
                ", status=" + status +
                ", id='" + id + '\'' +
                ", attributes=" + attributes +
                ", dimensions=" + dimensions +
                '}';
    }
}
