package in.dev.FileGenerator.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import in.dev.FileGenerator.processor.FileProcessor;

@Component
public class FileRouter extends RouteBuilder {

	//@Autowired
	//private FileProcessor fileProcessor;
	
	@Value("${number.of.copy}")
	private int numberOfCopy;
	
	@Value("${file.suffix}")
	private String fileSuffix;
	
	@Value("${file.prefix}")
	private String filePrefix;
	
	@Override
	public void configure() throws Exception {
		
		from("file:/home/user/indradeo/FileFolder/Source?noop=true&idempotent=true")
		.loop(numberOfCopy)
		.process(new FileProcessor(filePrefix, fileSuffix))
		.to("file:/home/user/indradeo/FileFolder/target")
		.log("Files Save to target folder")
		.end();
		System.out.println(numberOfCopy);
	}

}
