package com.efruit.micro.arkmanager.service.model;

//通用返回
public class ServiceResult<T> {
    private int code;//状态码
    private String desc;//描述信息
    private T data;//数据

    private ServiceResult(Builder<T> builder) {
        this.code = builder.code;
        this.desc = builder.desc;
        this.data = builder.data;
    }

    public static class Builder<T> {
        private int code;
        private String desc;
        private T data;

        public ServiceResult<T> builder() {
            return new ServiceResult<>(this);
        }

        public Builder(int code) {
            this.code = code;
        }

        public Builder() {
        }

        public Builder(String desc) {
            this.desc = desc;
        }

        public Builder(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public Builder(int code, String desc, T data) {
            this.code = code;
            this.desc = desc;
            this.data = data;
        }

        public int getCode() {
            return code;
        }

        public Builder setCode(int code) {
            this.code = code;
            return this;
        }

        public String getDesc() {
            return desc;
        }

        public Builder setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public T getData() {
            return data;
        }

        public Builder setData(T data) {
            this.data = data;
            return this;
        }
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
