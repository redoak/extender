package com.defold.extender.cache;

import com.defold.extender.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

public class CacheKeyGeneratorTest {

    private String generate(final String filename) throws URISyntaxException, IOException {
        CacheKeyGenerator cacheKeyGenerator = new CacheKeyGenerator();
        File file = new File(ClassLoader.getSystemResource(filename).toURI());
        return cacheKeyGenerator.generate(file);
    }

    @Test
    public void generateKeyForFile() throws IOException, URISyntaxException {
        assertEquals(TestUtils.CACHE_ENTRIES[0].getKey(), generate("upload/" + TestUtils.CACHE_ENTRIES[0].getPath()));
    }

    @Test
    public void generateKeyForAnotherFile() throws IOException, URISyntaxException {
        assertEquals(TestUtils.CACHE_ENTRIES[1].getKey(), generate("upload/" + TestUtils.CACHE_ENTRIES[1].getPath()));
    }
}