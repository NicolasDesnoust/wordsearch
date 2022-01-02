package io.github.nicolasdesnoust.wordsearch.configuration;

import io.github.nicolasdesnoust.wordsearch.domain.GridFactory;
import io.github.nicolasdesnoust.wordsearch.domain.OCRService;
import io.github.nicolasdesnoust.wordsearch.domain.WordsFactory;
import io.github.nicolasdesnoust.wordsearch.domain.wordfinding.BottomLeftToTopRightWordFinder;
import io.github.nicolasdesnoust.wordsearch.domain.wordfinding.BottomRightToTopLeftWordFinder;
import io.github.nicolasdesnoust.wordsearch.domain.wordfinding.BottomToTopWordFinder;
import io.github.nicolasdesnoust.wordsearch.domain.wordfinding.LeftToRightWordFinder;
import io.github.nicolasdesnoust.wordsearch.domain.wordfinding.RightToLeftWordFinder;
import io.github.nicolasdesnoust.wordsearch.domain.wordfinding.TopLeftToBottomRightWordFinder;
import io.github.nicolasdesnoust.wordsearch.domain.wordfinding.TopRightToBottomLeftWordFinder;
import io.github.nicolasdesnoust.wordsearch.domain.wordfinding.TopToBottomWordFinder;
import io.github.nicolasdesnoust.wordsearch.domain.wordfinding.WordFinder;
import io.github.nicolasdesnoust.wordsearch.domain.wordfinding.WordFindingFacade;
import io.github.nicolasdesnoust.wordsearch.usecases.ConvertsGridPictureUseCase;
import io.github.nicolasdesnoust.wordsearch.usecases.ConvertsWordsPictureUseCase;
import io.github.nicolasdesnoust.wordsearch.usecases.SolveWordSearchUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WordSearchApplicationContext {

    @Bean
    public ConvertsGridPictureUseCase convertsGridPictureUseCase(
            @Autowired OCRService ocrService,
            @Autowired GridFactory gridFactory
    ) {
        return new ConvertsGridPictureUseCase(ocrService, gridFactory);
    }

    @Bean
    public ConvertsWordsPictureUseCase convertsWordsPictureUseCase(
            @Autowired OCRService ocrService,
            @Autowired WordsFactory wordsFactory
    ) {
        return new ConvertsWordsPictureUseCase(ocrService, wordsFactory);
    }

    @Bean
    public SolveWordSearchUseCase solveWordSearchUseCase(
            @Autowired GridFactory gridFactory,
            @Autowired WordsFactory wordsFactory,
            @Autowired WordFindingFacade wordFindingFacade
    ) {
        return new SolveWordSearchUseCase(gridFactory, wordsFactory, wordFindingFacade);
    }

    @Bean
    public OCRService ocrService() {
        return new OCRService();
    }

    @Bean
    public GridFactory gridFactory() {
        return new GridFactory();
    }

    @Bean
    public WordsFactory wordsFactory() {
        return new WordsFactory();
    }

    @Bean
    public WordFindingFacade wordFindingFacade(@Autowired List<WordFinder> wordFinders) {
        return new WordFindingFacade(wordFinders);
    }

    @Bean
    public WordFinder leftToRightWordFinder() {
        return new LeftToRightWordFinder();
    }

    @Bean
    public WordFinder rightToLeftWordFinder() {
        return new RightToLeftWordFinder();
    }

    @Bean
    public WordFinder topToBottomWordFinder() {
        return new TopToBottomWordFinder();
    }

    @Bean
    public WordFinder bottomToTopWordFinder() {
        return new BottomToTopWordFinder();
    }

    @Bean
    public WordFinder bottomLeftToTopRightWordFinder() {
        return new BottomLeftToTopRightWordFinder();
    }

    @Bean
    public WordFinder bottomRightToTopLeftWordFinder() {
        return new BottomRightToTopLeftWordFinder();
    }

    @Bean
    public WordFinder topRightToBottomLeftWordFinder() {
        return new TopRightToBottomLeftWordFinder();
    }

    @Bean
    public WordFinder topLeftToBottomRightWordFinder() {
        return new TopLeftToBottomRightWordFinder();
    }
}
