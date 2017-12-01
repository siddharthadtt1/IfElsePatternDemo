package com.practice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IfElsePatternDemo {

	private static final String PATTERN_1 = "Pattern 1:";
	private static final String PATTERN_2 = "Pattern 2:";
	private static final String PATTERN_3 = "Pattern 3:";
	private static final String PATTERN_4 = "Pattern 4:";
	private static final String PATTERN_5 = "Pattern 5:";
	private static final String PATTERN_6 = "Pattern 6:";

	private static Map<String, PatternHandler> patternMap = new HashMap();

	public static void main(String[] args) {
		Map<String, List<String>> populatedEntryMap = getPopulatedHashMap();
		// System.out.println(populatedEntryMap);

		populatePatternMap();

		populatedEntryMap.forEach((key, value) -> {
			Pattern pattern = new Pattern();
			List<SubPattern> subPatterns = new ArrayList<>();
			pattern.setSubPatterns(subPatterns);

			value.forEach(entry -> {
				if (entry.contains(PATTERN_1))
					patternMap.get(PATTERN_1).handle(pattern, entry);
				else if (entry.contains(PATTERN_2))
					patternMap.get(PATTERN_2).handle(pattern, entry);
				else if (entry.contains(PATTERN_3))
					patternMap.get(PATTERN_3).handle(pattern, entry);
				else if (entry.contains(PATTERN_4))
					patternMap.get(PATTERN_4).handle(pattern, entry);
				else if (entry.contains(PATTERN_5))
					patternMap.get(PATTERN_5).handle(pattern, entry);
				else if (entry.contains(PATTERN_6))
					patternMap.get(PATTERN_6).handle(pattern, entry);
			});

			System.out.println(pattern);
			pattern.getSubPatterns().forEach(System.out::println);

		});

	}

	private static void populatePatternMap() {
		patternMap.put(PATTERN_1, (pattern, entryLine) -> {
			String value = entryLine.split(PATTERN_1)[1].trim();
			pattern.setValue1(value);
		});

		patternMap.put(PATTERN_2, (pattern, entryLine) -> {
			String value = entryLine.split(PATTERN_2)[1].trim();
			pattern.setValue2(value);
		});

		patternMap.put(PATTERN_3, (pattern, entryLine) -> {
			if (pattern.getValue3() == null) {
				String value = entryLine.split(PATTERN_3)[1].trim();
				String patternId = value + "_" + Instant.now().toEpochMilli();
				pattern.setValue3(value);
				pattern.setId(patternId);
			}
		});

		patternMap.put(PATTERN_4, (pattern, entryLine) -> {
			String value = entryLine.split(PATTERN_4)[1].trim();
			pattern.setValue4(value);
		});

		patternMap.put(PATTERN_5, (pattern, entryLine) -> {
			String value = entryLine.split(PATTERN_5)[1].trim();
			String subPatternId = pattern.getValue3() + "_" + Instant.now().toEpochMilli();
			SubPattern subPattern = getSubPattern(subPatternId, pattern.getId(), value);
			pattern.getSubPatterns().add(subPattern);
		});

		patternMap.put(PATTERN_6, (pattern, entryLine) -> {
			String value = entryLine.split(PATTERN_6)[1].trim();
			int index = pattern.getSubPatterns().size() - 1;
			SubPattern subPattern = pattern.getSubPatterns().get(index);
			subPattern.setValue2(value);
		});

	}

	private static SubPattern getSubPattern(String id, String patternId, String value) {
		SubPattern subPattern = new SubPattern();
		subPattern.setId(id);
		subPattern.setPatternId(patternId);
		subPattern.setValue1(value);

		return subPattern;
	}

	private static Map<String, List<String>> getPopulatedHashMap() {
		Map<String, List<String>> sampleHashMap = new HashMap<>();

		List<String> listValue1 = getEntryValueList1();
		sampleHashMap.put("key1", listValue1);

		List<String> listValue2 = getEntryValueList2();
		sampleHashMap.put("key2", listValue2);
		// sampleHashMap.put("key3", listValue1);
		// sampleHashMap.put("key4", listValue1);

		return sampleHashMap;
	}

	private static List<String> getEntryValueList1() {
		List<String> entryList = new ArrayList<>();

		entryList.add("Pattern 1: Value 1");
		entryList.add("Random 1 Pattern 2: Value 2");
		entryList.add("Random 2 Pattern 3: Value 3");
		entryList.add("Pattern 4: Value 4");
		entryList.add("Pattern 5: Value 5");
		entryList.add("Random Pattern 6: Value 6");
		entryList.add("Pattern 1: Value 1");
		entryList.add("Random 1 Pattern 2: Value 2");
		entryList.add("Random 2 Pattern 3: Value 3");
		entryList.add("Pattern 4: Value 4");
		entryList.add("Pattern 5: Value 7");
		entryList.add("Random Pattern 6: Value 8");

		return entryList;
	}

	private static List<String> getEntryValueList2() {
		List<String> entryList = new ArrayList<>();

		entryList.add("Pattern 1: Value 1");
		entryList.add("Random 1 Pattern 2: Value 2");
		entryList.add("Random 2 Pattern 3: Value 3");
		entryList.add("Pattern 4: Value 4");
		entryList.add("Pattern 5: Value 5");
		entryList.add("Random Pattern 6: Value 6");
		entryList.add("Pattern 1: Value 1");
		entryList.add("Random 1 Pattern 2: Value 2");
		entryList.add("Random 2 Pattern 3: Value 3");
		entryList.add("Pattern 4: Value 4");
		entryList.add("Pattern 5: Value 7");
		entryList.add("Random Pattern 6: Value 8");
		entryList.add("Pattern 5: Value 9");
		entryList.add("Random Pattern 6: Value 10");

		return entryList;
	}

}
