package com.aldeamo.trainning.fifa.monitoring;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import org.elasticsearch.metrics.ElasticsearchReporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;

/**
 * Ver docs en http://kielczewski.eu/2015/01/application-metrics-with-spring-boot-actuator/
 * 	https://blog.frankel.ch/become-a-devops-with-spring-boot
 * @author nelson
 */
@Configuration
public class DropwizardMetricsConfig {

	@Autowired
	private MetricRegistry registry;

	/**
	 * Configura un exporter para mostrar las metricas via JSON/REST en el path /metrics
	 * o en el MBean metrics
	 * @return
	 */
	@Bean
	public JmxReporter jmxReporter() {
		JmxReporter reporter = JmxReporter.forRegistry(registry).build();
		reporter.start();
		return reporter;
	}
	
	/**
	 * Crea un servidor de Graphite local y le envia las matricas
	 * @return
	 */
    /*@Bean
    public GraphiteReporter graphiteReporter() {
        Graphite graphite = new Graphite(new InetSocketAddress("localhost", 2003));
        GraphiteReporter reporter = GraphiteReporter.forRegistry(registry)
                                                    .prefixedWith("boot").build(graphite);
        reporter.start(500, TimeUnit.MILLISECONDS);
        return reporter;
    }*/
    
    /**
	 * Exporta las metricas a Elasticsearch para visualizarlas con Kibana
	 * @return
     * @throws IOException 
	 */
    @Bean
    public ElasticsearchReporter elasticsearchReporter() throws IOException {
        ElasticsearchReporter reporter = ElasticsearchReporter.forRegistry(registry)
        	    .hosts("localhost:9200", "localhost:9201")
        	    .prefixedWith("metrics")
        	    .build();
        	reporter.start(60, TimeUnit.SECONDS);
        return reporter;
    }
}