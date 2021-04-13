package com.CovidTacker.CovidTracker;


import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class DataService {

	private static String url = "https://api.covid19india.org/csv/latest/state_wise.csv";
	private ArrayList<Data> allData = new ArrayList<>(); 
	
	
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetch_data() throws IOException, InterruptedException {
		ArrayList<Data> newData = new ArrayList<>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(httpResponse.body());
		StringReader csvBodyReader = new StringReader(httpResponse.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {
			Data data = new Data();
		    data.setState(record.get("State"));
		    data.setConfirmed(record.get("Confirmed"));
		    data.setRecovered(record.get("Recovered"));
		    data.setActive(record.get("Active"));
		    data.setDeaths(record.get("Deaths"));
		    newData.add(data);
	}
	   this.allData=newData;
	}
}
