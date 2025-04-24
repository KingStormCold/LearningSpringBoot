package com.store_phone.response.specification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.dto.SpecificationDTO;
import com.store_phone.response.BaseInfo;

public class SpecificationResponse extends BaseInfo {
    @JsonProperty("specifications_id")
    private String specificationsId;

    @JsonProperty("specifications_content")
    private String specificationsContent;

    public String getSpecificationsId() {
        return specificationsId;
    }

    public void setSpecificationsId(String specificationsId) {
        this.specificationsId = specificationsId;
    }

    public String getSpecificationsContent() {
        return specificationsContent;
    }

    public void setSpecificationsContent(String specificationsContent) {
        this.specificationsContent = specificationsContent;
    }

    public SpecificationResponse(SpecificationDTO dto) {
        this.specificationsId = dto.getSpecificationsId();
        this.specificationsContent = getSpecificationsContent();
        this.updatedBy = dto.getUpdatedBy();
        this.updatedDate = dto.getUpdatedDate();
        this.createdDate = dto.getUpdatedDate();
        this.createdBy = dto.getCreatedBy();
    }
}
