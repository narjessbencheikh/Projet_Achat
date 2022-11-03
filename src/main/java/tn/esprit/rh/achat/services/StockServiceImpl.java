package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;


	@Override
	public List<Stock> retrieveAllStocks() {
		// récuperer la date à l'instant t1
		System.out.println("In method retrieveAllStocks");
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		for (Stock stock : stocks) {
			System.out.println(" Stock : " + stock);
		}
		System.out.println("out of method retrieveAllStocks");
		// récuperer la date à l'instant t2
		// temps execution = t2 - t1
		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {
		// récuperer la date à l'instant t1
		System.out.println("In method addStock");
		return stockRepository.save(s);
		
	}

	@Override
	public void deleteStock(Long stockId) {
		System.out.println("In method deleteStock");
		stockRepository.deleteById(stockId);

	}

	@Override
	public Stock updateStock(Stock s) {
		System.out.println("In method updateStock");
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long stockId) {
		long start = System.currentTimeMillis();
		System.out.println("In method retrieveStock");
		Stock stock = stockRepository.findById(stockId).orElse(null);
		System.out.println("out of method retrieveStock");
		 long elapsedTime = System.currentTimeMillis() - start;
		 System.out.println("Method execution time: " + elapsedTime + " milliseconds.");

		return stock;
	}

	@Override
	public String retrieveStatusStock() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		String finalMessage = "";
		String newLine = System.getProperty("line.separator");
		List<Stock> stocksEnRouge = (List<Stock>) stockRepository.retrieveStatusStock();
		for (int i = 0; i < stocksEnRouge.size(); i++) {
			finalMessage = newLine + finalMessage + msgDate + newLine + ": le stock "
					+ stocksEnRouge.get(i).getLibelleStock() + " a une quantité de " + stocksEnRouge.get(i).getQte()
					+ " inférieur à la quantité minimale a ne pas dépasser de " + stocksEnRouge.get(i).getQteMin()
					+ newLine;

		}
		System.out.println(finalMessage);
		return finalMessage;
	}

}