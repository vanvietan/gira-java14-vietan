package cybersoft.javabackend.girajava14vietan.security.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {
	
	@Value("${gira.security.jwt.expiration}")
	private String jwtExpiration; //hết hạn 1 giờ
	@Value("${gira.security.jwt.secret}")
	private String secret;
	
	public String generateJwtToken(Authentication authentication) {
		UserDetails userInfo = (UserDetails) authentication.getPrincipal();
		Date now = new Date();
		
		return Jwts.builder()
				.setSubject(userInfo.getUsername())
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + Long.parseLong(jwtExpiration)))
				.signWith(SignatureAlgorithm.HS512 , secret)
				.compact();
	}
	public String generateFakeJwtToken(String username) {
		Date now = new Date();
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + Long.parseLong(jwtExpiration)))
				.signWith(SignatureAlgorithm.HS512 , secret)
				.compact();
	}
	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		}catch(SignatureException e1) {							
			log.error("Invalid JWT Signature: {}" , e1.getMessage());		//sai chữ ký
		}catch(ExpiredJwtException e2) {
			log.error("JWT Token is expired:{}" , e2.getMessage());			//hết hạn
		}catch(MalformedJwtException e3) {
			log.error("Invalid JWT Token: {}" , e3.getMessage());			//sai kiểu token
		}catch(IllegalArgumentException e4) {
			log.error("JWT claims string is empty: {}" , e4.getMessage());	//token ko hợp lệ
		}catch(UnsupportedJwtException e5) {
			log.error("JWT is not supported: {}" , e5.getMessage());		//token không support
		}
		return false;
	}
	
}
