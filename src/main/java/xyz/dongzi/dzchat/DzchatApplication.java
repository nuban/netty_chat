package xyz.dongzi.dzchat;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xyz.dongzi.dzchat.util.IdWorker;

@SpringBootApplication
@MapperScan("xyz.dongzi.dzchat.mapper")
public class DzchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(DzchatApplication.class, args);
    }

    /**
     * 初始化id生成器
     * @return
     */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(0, 0);
    }
}
