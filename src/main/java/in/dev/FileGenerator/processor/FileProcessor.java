package in.dev.FileGenerator.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class FileProcessor implements Processor{
	
	private  String filePrefix;
	private  String fileSuffix;
	
	public FileProcessor() {}

	public FileProcessor(String filePrefix, String fileSuffix) {
		this.filePrefix=filePrefix;
		this.fileSuffix=fileSuffix;
	}


	@Override
	public void process(Exchange exchange) throws Exception {

		int index = exchange.getProperty("CamelLoopIndex", Integer.class) + 1;
        String paddedNumber = String.format("%03d", index); 
        String fileName = filePrefix + paddedNumber + fileSuffix;
        exchange.getIn().setHeader("CamelFileName", fileName);
		
	}

}
