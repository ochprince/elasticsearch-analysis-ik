package com.colasoft.opensearch.plugin.analysis.ik;

import org.apache.lucene.analysis.Analyzer;
import com.colasoft.opensearch.index.analysis.AnalyzerProvider;
import com.colasoft.opensearch.index.analysis.IkAnalyzerProvider;
import com.colasoft.opensearch.index.analysis.IkTokenizerFactory;
import com.colasoft.opensearch.index.analysis.TokenizerFactory;
import com.colasoft.opensearch.indices.analysis.AnalysisModule;
import com.colasoft.opensearch.plugins.AnalysisPlugin;
import com.colasoft.opensearch.plugins.Plugin;

import java.util.HashMap;
import java.util.Map;


public class AnalysisIkPlugin extends Plugin implements AnalysisPlugin {

	public static String PLUGIN_NAME = "analysis-ik";

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> extra = new HashMap<>();


        extra.put("ik_smart", IkTokenizerFactory::getIkSmartTokenizerFactory);
        extra.put("ik_max_word", IkTokenizerFactory::getIkTokenizerFactory);

        return extra;
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> extra = new HashMap<>();

        extra.put("ik_smart", IkAnalyzerProvider::getIkSmartAnalyzerProvider);
        extra.put("ik_max_word", IkAnalyzerProvider::getIkAnalyzerProvider);

        return extra;
    }

}
