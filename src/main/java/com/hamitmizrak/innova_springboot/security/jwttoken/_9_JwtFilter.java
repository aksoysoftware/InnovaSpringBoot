// Bu sınıfın com.hamitmizrak.innova_springboot.security.jwt paketi altında yer aldığını belirtir.
package com.hamitmizrak.innova_springboot.security.jwttoken;

// Lombok kütüphanesinden @RequiredArgsConstructor, final değişkenler için otomatik olarak constructor oluşturur.
import lombok.RequiredArgsConstructor;

// Spring Security tarafından kimlik doğrulama için kullanılan bir token sınıfı.
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// Uygulama genelinde güvenlik bilgilerini tutar. Örneğin, kullanıcı oturum bilgileri.
import org.springframework.security.core.context.SecurityContextHolder;

// Kullanıcı detaylarını tutan bir arayüz. Genellikle kullanıcı bilgilerini temsil eder.
import org.springframework.security.core.userdetails.UserDetails;

// Kullanıcı detaylarını yüklemek için kullanılan bir servis arayüzü.
import org.springframework.security.core.userdetails.UserDetailsService;

// Spring bileşeni olarak bu sınıfın kullanılmasını sağlar.
import org.springframework.stereotype.Component;

// Her HTTP isteği için bir kez çalışacak olan bir filtre sınıfı.
import org.springframework.web.filter.OncePerRequestFilter;

// Giriş/çıkış işlemleri sırasında ortaya çıkabilecek istisnaları işlemek için kullanılır.
import java.io.IOException;


// LOMBOK
// Lombok tarafından sağlanan bu notasyon, final olarak tanımlanmış değişkenler için bir constructor oluşturur.
@RequiredArgsConstructor


@Component
// Bu sınıfı bir Spring bileşeni olarak işaretler.
// IOC konteynerine dahil edilir ve diğer bileşenlerde kullanılabilir.
public class _9_JwtFilter extends OncePerRequestFilter {

    // Injection
    // JWT işlemleri için kullanılan yardımcı sınıf.
    // Token oluşturma ve doğrulama işlevlerini sağlar.
    private final _7_JwtUtils jwtUtils;

    // Kullanıcı bilgilerini yüklemek için kullanılan Spring Security bileşeni.
    private final UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        // HTTP istekleri için özel filtre mantığını uygular.

        // HTTP isteğinin "Authorization" başlığını alır.
        String header = request.getHeader("Authorization");

        // token ve username
        String token = null;
        String username = null;

        // Eğer "Authorization" başlığı mevcutsa ve "Bearer " ile başlıyorsa:
        if (header != null && header.startsWith("Bearer ")) {

            // "Bearer " ifadesinden sonraki token kısmını alır.
            token = header.substring(7);

            // Token içerisinden kullanıcı adını ayrıştırır.
            username = jwtUtils.getUsernameFromJwtToken(token);
        }

        // Eğer username varsa ve mevcut oturumda kimlik doğrulama bilgisi yoksa:
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Kullanıcı detaylarını yükler.
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);


            // Eğer token geçerliyse:
            if (jwtUtils.validateJwtToken(token)) {
                // Kullanıcı kimlik doğrulama bilgilerini Spring Security'ye ayarlar.
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities()));

            }
        }

        // İsteği bir sonraki filtreye veya hedefe iletir.
        filterChain.doFilter(request, response);
    } //end doFilterInternal
} //end _9_JwtFilter
