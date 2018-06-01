package com.parkmobile.asilvia.vehicles.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by asilvia on 01/06/2018.
 */

@RunWith(JUnit4.class)
public class MainApiHelperTest {


    @Test
   public void error() {
        ApiResponse<String> response = new ApiResponse<String>(Response.error(400,
        ResponseBody.create(MediaType.parse("application/txt"), "page not found")));
        assertThat(response.code, is(400));
        assertThat(response.errorMessage, is("page not found"));
    }

    @Test
   public void success() {
        ApiResponse<String> apiResponse = new ApiResponse<>(Response.success("foo"));
        assertThat(apiResponse.errorMessage, nullValue());
        assertThat(apiResponse.code, is(200));
        assertThat(apiResponse.body, is("foo"));
        assertThat(apiResponse.getNextPage(), is(nullValue()));
    }

}