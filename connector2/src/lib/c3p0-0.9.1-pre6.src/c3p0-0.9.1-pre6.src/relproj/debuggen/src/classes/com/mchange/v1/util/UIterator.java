/*
 * Distributed as part of debuggen v.0.1.0
 *
 * Copyright (C) 2005 Machinery For Change, Inc.
 *
 * Author: Steve Waldman <swaldman@mchange.com>
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 2.1, as 
 * published by the Free Software Foundation.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this software; see the file LICENSE.  If not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 */


package com.mchange.v1.util;

/**
 * Incomplete parent of "Unreliable Iterator"
 * This is often bound to a scarce resource! Don't
 * forget to close it when you are done!!!
 *
 * This interface is not intended to be implemented
 * directly, but to be extended by subinterfaces
 * that narrow the exceptions reasonably.
 */
public interface UIterator extends ClosableResource
{
    public boolean hasNext() throws Exception;
    public Object  next()    throws Exception;
    public void    remove()  throws Exception;
    public void    close() throws Exception;
}

