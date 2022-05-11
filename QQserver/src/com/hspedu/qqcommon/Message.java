package com.hspedu.qqcommon;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 1.0
 * 表示客户端和服务端通信时消息对象
 */
public class Message implements Serializable {
    //保证序列化兼容性
    private static final long serialVersionUID = 11;
    private String sender; //发送者
    private String getter; //接收者
    private String content; //发送消息内容
    private String sendTime; //发送时间
    private String mesType;//消息类型[可以在接口定义消息类型]

    //文件属性成员
    private byte[] fileBytes;
    private int fileLen = 0;
    private String desc;
    private String src;

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Message() {}

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Message(String sender, String getter, String content, String sendTime) {
        this.sender = sender;
        this.getter = getter;
        this.content = content;
        this.sendTime = sendTime;
    }

    public Message(String mesType) {
        this.mesType = mesType;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}
