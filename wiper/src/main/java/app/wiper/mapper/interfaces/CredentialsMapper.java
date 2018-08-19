package app.wiper.mapper.interfaces;

import app.wiper.domain.core.Credentials;

import java.util.Map;

public interface CredentialsMapper
{
    Integer getCredentialsByEmailId(String emailId);
    Integer getCredentialsByPhoneNumber(String phoneNumber);
    Credentials getCredentialsForEntityIdAndEntityTypeId(Integer entityTypeId, Integer  entityId);
    void upsertCredentials(Map<String, Object> params);
}
