/*
 * Copyright 2018-2019 Expedia Group, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expedia.adaptivealerting.anomdetect.comp.connector;

import lombok.Generated;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * Simple wrapper around Apache's fluent HTTP client, intended to support mockability.
 */
public class HttpClientWrapper {

    /**
     * Makes an HTTP GET call to the given URI and returns the result.
     *
     * @param uri URI
     * @return Call result
     * @throws IOException if there's a problem making the call
     */
    @Generated // https://reflectoring.io/100-percent-test-coverage/
    public Content get(String uri) throws IOException {
        return Request.Get(uri)
                .execute()
                .returnContent();
    }
}
