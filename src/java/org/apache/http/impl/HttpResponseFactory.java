/*
 * $HeadURL$
 * $Revision$
 * $Date$
 *
 * ====================================================================
 *
 *  Copyright 1999-2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http.impl;

import org.apache.http.HttpMutableResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;

/**
 * <p>
 * </p>
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision$
 * 
 * @since 4.0
 */
public class HttpResponseFactory {
    
    private HttpResponseFactory() {
        super();
    }

    public static HttpMutableResponse newHttpResponse(final HttpVersion ver, final int status)
            throws MethodNotSupportedException {
        if (ver == null) {
            throw new IllegalArgumentException("HTTP version may not be null");
        }
        StatusLine statusline = new StatusLine(ver, status, HttpStatus.getStatusText(status)); 
        return new BasicHttpResponse(statusline); 
    }
    
    public static HttpMutableResponse newHttpResponse(final StatusLine statusline)
            throws MethodNotSupportedException {
        if (statusline == null) {
            throw new IllegalArgumentException("Status line may not be null");
        }
        return new BasicHttpResponse(statusline); 
    }
}
