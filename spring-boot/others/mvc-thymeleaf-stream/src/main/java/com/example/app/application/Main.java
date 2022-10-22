package com.example.app.application;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		String result = main.collectorUnmodificable();
		System.out.println(result);

	}
	
	// ***** FOR EACH ***** //
	// Method forEach() works on current stream. For primitives and String is used mainly for display text.
	// But for objects can be used for data modification.
	
	public String forEachStringsSimple() {
		
		List<String> inputs = Arrays.asList("Hello World");
		
		inputs
			.stream()
			.forEach(e -> System.out.println(e));
		
		return inputs.get(0);
		
	}
	
	public String forEachStringsExtended() {
		
		List<String> inputs = Arrays.asList("Some Text", "Hello World", "Another Text");
		
		inputs
			.stream()
			.forEach(e -> {
				System.out.println("For Each Strings Extended");
				if ("Hello World".equals(e)) {
					e = "Hello World Extended";
					System.out.println(e);
				}					
			});
		
		return inputs.get(1);
		
	}
	
	public String forEachObjectSimple() {
		
		List<Greeting> inputs = Arrays.asList(new Greeting("Hello World"));
		
		inputs
			.stream()
			.forEach(e -> System.out.println(e.getText()));
		
		return inputs.get(0).getText();
		
	}
	
	public String forEachObjectExtended() {
		
		List<Greeting> inputs = Arrays.asList(new Greeting("Some Text"), new Greeting("Hello"), new Greeting("Another Text"));
		
		inputs
			.stream()
			.forEach(e -> {
				if ("Hello".equals(e.getText())) {
					e.setText("Hello World");
					System.out.println(e.getText());
				}
			});
		
		return inputs.get(1).getText();
		
	}
	
	// ***** MAP ***** //
	// Method map() maps one object to another. It takes as argument object type input and returns object type output.
	
	public String mapStringsSimple() {
		
		List<String> inputs = Arrays.asList("Some Text", "Hello World", "Another Text");
		
		List<Greeting> outputs = inputs
			.stream()
			.map(e -> new Greeting(e))
			.collect(Collectors.toList());
		
		return outputs.get(1).getText();
		
	}
	
	public String mapStringsExtended() {
		
		List<String> inputs = Arrays.asList("Some Text", "Hello World", "Another Text");
		
		List<Greeting> outputs = inputs
			.stream()
			.map(e -> {
				System.out.println(e);
				return new Greeting(e);
			})
			.collect(Collectors.toList());
		
		return outputs.get(1).getText();
		
	}
	
	public String mapObjectsSimple() {
		
		List<Greeting> inputs = Arrays.asList(new Greeting("Some Text"), new Greeting("Hello World"), new Greeting("Another Text"));
		
		List<String> outputs = inputs
			.stream()
			.map(e -> e.customMap())
			.collect(Collectors.toList());
		
		return outputs.get(1);
		
	}
	
	public String mapObjectsExtended() {
		
		List<Greeting> inputs = Arrays.asList(new Greeting("Some Text"), new Greeting("Hello"), new Greeting("Another Text"));
		
		List<String> outputs = inputs
			.stream()
			.map(e -> {
				System.out.println(e);
				return e.customMap();
			})
			.collect(Collectors.toList());
		
		return outputs.get(1);
		
	}	
	
	// ***** FILTER ***** //
	// Method filter() filters stream and leaves only objects which fits. It takes as argument object type input and returns true or false.
	
	public String filterStringsSimple() {
		
		List<String> inputStringList = Arrays.asList("Some Text", "Hello World", "Another Text");
		
		List<String> outputStringList = inputStringList
			.stream()
			.filter(e -> e.equals("Hello World"))
			.collect(Collectors.toList());
		
		return outputStringList.get(0);
		
	}
	
	public String filterStringsExtended() {
		
		List<String> inputStringList = Arrays.asList("Some Text", "Hello World", "Another Text");
		
		List<String> outputStringList = inputStringList
			.stream()
			.filter(e -> {
				System.out.println("Filter Strings Extended");
				return e.equals("Hello World");
			})
			.collect(Collectors.toList());
		
		return outputStringList.get(0);
		
	}
	
	public String filterObjectsSimple() {
		
		List<Greeting> inputStringList = Arrays.asList(new Greeting("Some Text"), new Greeting("Hello World"), new Greeting("Another Text"));
		
		List<Greeting> outputStringList = inputStringList
			.stream()
			.filter(e -> e.customFilter())
			.collect(Collectors.toList());
		
		return outputStringList.get(0).getText();
		
	}
	
	public String filterObjectsExtended() {
		
		List<Greeting> inputStringList = Arrays.asList(new Greeting("Some Text"), new Greeting("Hello World"), new Greeting("Another Text"));
		
		List<Greeting> outputStringList = inputStringList
			.stream()
			.filter(e -> {
				System.out.println("Filter Objects Extended");
				return e.customFilter();
			})
			.collect(Collectors.toList());
		
		return outputStringList.get(0).getText();
		
	}
	
	// ***** METHOD REFERENCE OPERATOR ***** //
	
	public String methodReference() {
		
		List<Greeting> inputs = Arrays.asList(new Greeting("Hello"));
		
		inputs
			.stream()
			.forEach(Greeting::methodReference);
		
		return inputs.get(0).getText();
		
	}
	
	public String methodReferenceStatic() {
		
		List<Greeting> inputs = Arrays.asList(new Greeting("Hello"));
		
		inputs
			.stream()
			.forEach(GreetingStatic::methodReference);
		
		return inputs.get(0).getText();
		
	}
	
	// ***** ORDER ***** //
	
	public String orderFilterMap() {
		
		List<String> inputStringList = Arrays.asList("Hello", "World", "Hello World");
		
		long count = inputStringList
			.stream()
			.filter(e -> {
				return e.equals("Hello World");
			})
			.map(e -> {
				if (e.equals("Hello")) {
					return e.concat(" World");
				}
				return e;
			})
			.collect(Collectors.toList()).size();
		
		return "Hello World count: " + count;
		
	}
	
	public String orderMapFilter() {
		
		List<String> inputStringList = Arrays.asList("Hello", "World", "Hello World");
		
		long count = inputStringList
			.stream()			
			.map(e -> {
				if (e.equals("Hello")) {
					return e.concat(" World");
				}
				return e;
			})
			.filter(e -> {
				return e.equals("Hello World");
			})
			.collect(Collectors.toList()).size();
		
		return "Hello World count: " + count;
		
	}
	
	// ***** COLLECTOR ***** //
	
	public String collectorToList() {
		
		List<Greeting> greetings = Arrays.asList(new Greeting(1, "Hello World"), new Greeting(2, "Hello World"), new Greeting(3, "Hello World"));
		
		List<Greeting> result = greetings.stream().collect(Collectors.toList());
		
		return result.get(0).getText();
		
	}
	
	public String collectorJoining() {
		
		List<Greeting> greetings = Arrays.asList(new Greeting(1, "Hello World"), new Greeting(2, "Hello World"), new Greeting(3, "Hello World"));
		
		String result = greetings.stream().map(e -> e.getText()).collect(Collectors.joining(", ", "[", "]"));
		System.out.println(result);
		
		return result.split(",")[1];
		
	}
	
	public String collectorAveragingInt() {
		
		List<Greeting> greetings = Arrays.asList(new Greeting(1, "Hello World"), new Greeting(2, "Hello World"), new Greeting(3, "Hello World"));
		
		Double result = greetings.stream().collect(Collectors.averagingInt(Greeting::getId));
		
		return "Hello World average id: " + result;
		
	}
	
	public String collectorSummarizingInt() {
		
		List<Greeting> greetings = Arrays.asList(new Greeting(1, "Hello World"), new Greeting(2, "Hello World"), new Greeting(3, "Hello World"));
		
		IntSummaryStatistics summary = greetings.stream().collect(Collectors.summarizingInt(Greeting::getId));
		System.out.println("Average: " + summary.getAverage());
		System.out.println("Count: " + summary.getCount());
		System.out.println("Max: " + summary.getMax());
		System.out.println("Min: " + summary.getMin());
		System.out.println("Sum: " + summary.getSum());
		
		return "Hello World average id: " + summary.getAverage();
		
	}
	
	public String collectorGroupingBy() {
		
		List<Greeting> greetings = Arrays.asList(
				new Greeting(1, "Hello World"), new Greeting(1, "Hello World"), new Greeting(1, "Hello World"), 
				new Greeting(2, "Hello World"), new Greeting(2, "Hello World"), 
				new Greeting(3, "Hello World"));
		
		Map<Integer, List<Greeting>> resultMap = greetings.stream().collect(Collectors.groupingBy(Greeting::getId));
		for (Integer id : resultMap.keySet()) {
			System.out.println(String.format("Count of Greetings with id %s is: %s", id, resultMap.get(id).size()));
		}
		
		return resultMap.get(1).get(0).getText();
		
	}
	
	public String collectorPartitioningBy() {
		
		List<Greeting> greetings = Arrays.asList(new Greeting(1, "Hello World"), new Greeting(2, "Hello World"), new Greeting(3, "Hello World"));
		
		Map<Boolean, List<Greeting>> resultMap = greetings.stream().collect(Collectors.partitioningBy(element -> element.getId() < 2));
		System.out.println("Count of Greeting with id lower then 2 is : " + resultMap.get(Boolean.TRUE).size());
		System.out.println("Count of Greeting with id higher or equal 2 is : " + resultMap.get(Boolean.FALSE).size());
		
		return resultMap.get(Boolean.TRUE).get(0).getText();
		
	}
	
	public String collectorCollectingAndThen() {
		
		List<Greeting> greetings = Arrays.asList(new Greeting(1, "Hello World"), new Greeting(2, "Hello World"), new Greeting(3, "Hello World"));
		
		Double result = greetings.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Greeting::getId), element -> element + 0));
		
		return "Hello World average id: " + result;
		
	}
	
	public String collectorUnmodificable() {
		
		List<Greeting> greetings = Arrays.asList(new Greeting(1, "Hello World"), new Greeting(2, "Hello World"), new Greeting(3, "Hello World"));
		
		List<Greeting> result = greetings.stream().collect(Collectors.collectingAndThen(Collectors.toList(),
				  Collections::unmodifiableList));
		
		try {
			result.set(0, new Greeting(4, "Hello World 4"));
		} catch (Exception e) {
			System.out.println("Can not modificate");
		}
		
		return result.get(0).getText();
		
	}
	
	// ***** OTHER ***** //
	
	public String skip() {
		
		List<String> input = Arrays.asList("Some Text", "Hello World", "Another Text");
		
		List<String> output = input
			.stream()
			.skip(1)
			.collect(Collectors.toList());
		
		return output.get(0);
		
	}
	
	public String count() {
		
		List<String> input = Arrays.asList("Hello World", "Hello World", "Hello World");
		
		long count = input
			.stream()
			.count();
		
		return "Hello World count: " + count;
		
	}
	
	public String empty() {
		
		List<String> input = Arrays.asList("Hello World");
		
		Stream<String> inputStream = (input == null || input.isEmpty() ? Stream.empty() : input.stream());
		List<String> output = inputStream.collect(Collectors.toList());
		
		return output.get(0);
		
	}
	
	public String fromCollection() {
		
		List<String> input = Arrays.asList("Hello World");
		
		List<String> output = input.stream().collect(Collectors.toList());
		
		return output.get(0);
		
	}
	
	public String fromArray() {
		
		String[] input = {"Hello World"};
		
		List<String> output = Arrays.stream(input).collect(Collectors.toList());
		
		return output.get(0);
		
	}
	
	public String builder() {
		
		Stream<String> input = Stream.<String>builder().add("Hello World").add("Hello").add("Woeld").build();
		
		List<String> output = input.collect(Collectors.toList());
		
		return output.get(0);
		
	}
	
	public String generate() {
		
		Stream<String> input = Stream.generate(() -> "Hello World").limit(3);
		
		List<String> output = input.collect(Collectors.toList());
		
		return output.get(0);
		
	}
	
	
	// Results: 0: "Hello ", 1: "Hello World", 2: "Hello WorldWorld"
	public String iterate() {
		
		Stream<String> input = Stream.iterate("Hello ", n -> n + "World").limit(3);
		
		List<String> output = input.collect(Collectors.toList());
		
		return output.get(1);
		
	}
	
	public String findAny() {
		
		List<String> input = Arrays.asList("Hello World", "Hello World", "Hello World");
		
		String output = input
			.stream()			
			.findAny()
			.get();
		
		return output;
		
	}
	
	public String findFirst() {
		
		List<String> input = Arrays.asList("Hello World", "Hello World", "Hello World");
		
		String output = input
			.stream()			
			.findFirst()
			.get();
		
		return output;
		
	}
	
	// ---------------
	
	
	class Greeting {
		
		private int id;
		private String text;
		
		
		public Greeting(int id, String text) {
			this.id = id;
			this.text = text;
		}
		public Greeting(String text) {
			this.text = text;
		}
		
		public String customMap() {
			return getText();
		}		
		
		public boolean customFilter() {
			return getText().equals("Hello World");
		}
		
		public void methodReference() {
			if ("Hello".equals(text)) {
				setText("Hello World");
				System.out.println(getText());
			}
		}		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}		
		
	}
	
	static class GreetingStatic {
		
		public static void methodReference(Greeting greeting) {
			if ("Hello".equals(greeting.getText())) {
				greeting.setText("Hello World");
				System.out.println(greeting.getText());
			}
		}
		
	}

}
