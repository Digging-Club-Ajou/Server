package server.mapper.member.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record KakaoToken( String tokenType,
                          String accessToken,
                          String idToken,
                          Integer expiresIn,
                          String refreshToken,
                          Integer refreshTokenExpiresIn,
                          String scope) {
}
