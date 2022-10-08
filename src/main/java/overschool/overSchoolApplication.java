package overschool;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"overschool.repository"})
public class overSchoolApplication {




    public static void main(String[] args) {
        IdGeneratorOptions options = new IdGeneratorOptions();

        options.WorkerIdBitLength = 9;
        options.SeqBitLength = 6;
        YitIdHelper.setIdGenerator(options);
        SpringApplication.run(overSchoolApplication.class);
//        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());


    }

}
