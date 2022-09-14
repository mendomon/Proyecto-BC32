package pe.com.BC32.app.parameter.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.BC32.app.parameter.entity.Parameter;
import reactor.core.publisher.Flux;

public interface IParameterRepository extends ReactiveMongoRepository<Parameter, String> {

    @Query("{'paramNumber': ?0}")
    Flux<Parameter> findByParamNumber(String paramNumber);
}
