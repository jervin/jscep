/*
 * Copyright (c) 2009 David Grant
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.google.code.jscep.content;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

// TODO: Should this return a CertRep instead?
/**
 * Content handler for PKIOperation requests. 
 */
public class CertRepContentHandler implements ScepContentHandler<byte[]> {
	/**
	 * {@inheritDoc}
	 */
    public byte[] getContent(InputStream in, String mimeType) throws IOException {
    	if (mimeType.equals(PKI_MESSAGE)) {
    		BufferedInputStream is = new BufferedInputStream(in);
    		ByteArrayOutputStream baos = new ByteArrayOutputStream();
    		
    		int b;
    		while ((b = is.read()) != -1)
    			baos.write(b);
    		
            return baos.toByteArray();
    	} else {
    		throw new IOException("Invalid Content Type");
    	}
    }
}