package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class )
        // Configuration annotation이 붙은 건 filtering 하겠단 뜻. (빈으로 등록하지 않겠다) -> 기존의 AppConfig때문에 해놓은 것.
)
public class AutoAppConfig {
}
