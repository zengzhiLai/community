package cn.lnsf.community.community.dto;

import lombok.Data;

/**
 * @author ：赖增智
 * @date ：Created in 2019-6-1 13:45
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
