//  **********************************************************************
//  Copyright (c) 2017 Ericsson Telekommunikation GmbH.
//  All rights reserved.
//  The Copyright to the computer program(s) herein is the property of
//  Ericsson Telekommunikation GmbH.
//  The program(s) may be used and/or copied with the written permission
//  from Ericsson Telekommunikation GmbH or in accordance with the terms
//  and conditions stipulated in the agreement/contract under which the
//  program(s) have been supplied.
//  **********************************************************************

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Key
{
    List<String> ids = new ArrayList<String>();
    public Key(String... strings) {
        ids = Arrays.asList(strings);
    }
}
