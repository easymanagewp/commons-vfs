/*
 * Copyright (C) The Apache Software Foundation. All rights reserved.
 *
 * This software is published under the terms of the Apache Software License
 * version 1.1, a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 */
package org.apache.commons.vfs.provider.local;

import org.apache.commons.vfs.FileName;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.provider.AbstractFileSystem;
import org.apache.commons.vfs.provider.DefaultFileName;
import org.apache.commons.vfs.provider.FileSystem;
import org.apache.commons.vfs.provider.FileSystemProviderContext;

/**
 * A local file system.
 *
 * @author <a href="mailto:adammurdoch@apache.org">Adam Murdoch</a>
 * @version $Revision: 1.4 $ $Date: 2002/07/05 04:08:18 $
 */
final class LocalFileSystem
    extends AbstractFileSystem
    implements FileSystem
{
    private final String m_rootFile;

    public LocalFileSystem( final FileSystemProviderContext context,
                            final DefaultFileName rootName,
                            final String rootFile )
    {
        super( context, rootName );
        m_rootFile = rootFile;
    }

    /**
     * Creates a file object.
     */
    protected FileObject createFile( final FileName name ) throws FileSystemException
    {
        // Create the file
        final String fileName = m_rootFile + name.getPath();
        return new LocalFile( this, fileName, name );
    }
}