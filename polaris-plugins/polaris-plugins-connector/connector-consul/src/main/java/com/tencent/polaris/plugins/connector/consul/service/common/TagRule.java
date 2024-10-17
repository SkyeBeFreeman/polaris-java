package com.tencent.polaris.plugins.connector.consul.service.common;

import java.util.List;

/**
 * 标签规则
 *
 * @author vanqfjiang
 */
public class TagRule {
    /**
     * 规则ID
     */
    private String id;
    /**
     * 规则名
     */
    private String name;
    /**
     * 规则引用的标签列表
     */
    private List<TagCondition> conditions;
    /**
     * 规则运算表达式 only support {0} AND {1} AND ...
     */
    private String conditionExpression;

    @Override
    public String toString() {
        return String.format("TagRule{id=%s, name=%s, condition=%s, expression=%s}", this.id, this.name,
                this.conditions, this.conditionExpression);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TagCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<TagCondition> conditions) {
        this.conditions = conditions;
    }

    public String getConditionExpression() {
        return conditionExpression;
    }

    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }
}
