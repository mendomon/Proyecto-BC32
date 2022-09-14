package pe.com.BC32.app.bootcoinuser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class BootCoinUserMain {
    public static void main(String[] args) {
        log.debug("Application Start - DEBUG");
        log.error("Application Start - ERROR");
        log.info("Application Start - INFO");
        log.trace("Application Start - TRACE");
        log.warn("Application Start - WARN");
        SpringApplication.run(BootCoinUserMain.class, args);
    }
}