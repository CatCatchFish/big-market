package cn.cat.trigger.api;

import cn.cat.types.model.Response;

public interface IDCCService {
    Response<Boolean> updateConfig(String key, String value);
}
