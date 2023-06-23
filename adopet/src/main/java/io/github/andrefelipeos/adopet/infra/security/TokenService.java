package io.github.andrefelipeos.adopet.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import io.github.andrefelipeos.adopet.domain.usuario.Usuario;

@Service
public class TokenService {

	public String gerarToken(Usuario usuario) {
		try {
		    Algorithm algoritmo = Algorithm.HMAC256("senhafraca");
		    return JWT.create()
		        .withIssuer("adopet")
		        .withSubject(usuario.getLogin())
		        .withExpiresAt(dataExpiracao())
		        .sign(algoritmo);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar token JWT", exception);
		}
	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
