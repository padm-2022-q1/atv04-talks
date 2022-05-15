package br.edu.ufabc.talks.model

/**
 * A static class that holds the app initial data.
 */
object Dataset {
    /**
     * the list of videos.
     */
    val videos = listOf(
        VideoDTO(
            1,
            "How Mars might hold the secret to the origin of life",
            "TED2015",
            15 * 60 + 53,
            Video.parseDate("Mar 2015"),
            "Nathalie Cabrol",
            "https://www.ted.com/talks/nathalie_cabrol_how_mars_might_hold_the_secret_to_the_origin_of_life",
            "https://firebasestorage.googleapis.com/v0/b/padm-atv04-talks.appspot.com/o/" +
                "NathalieCabrol_2015-480p.jpg?alt=media&token=031bc014-0093-4f9b-a39c-2ff04ffd1995",
            "https://firebasestorage.googleapis.com/v0/b/padm-atv04-talks.appspot.com/o/" +
                "NathalieCabrol_2015-480p_small.webm?alt=media&token=e691b15f-1892-4d62-a1e3-26b3f71c6e01",
        ),
        VideoDTO(
            2,
            "Math is forever",
            "TEDxRiodelaPlata",
            9 * 60 + 28,
            Video.parseDate("Oct 2014"),
            "Eduardo Sáenz de Cabezón",
            "https://www.ted.com/talks/eduardo_saenz_de_cabezon_math_is_forever",
            "https://firebasestorage.googleapis.com/v0/b/padm-atv04-talks.appspot.com/o/" +
                "EduardoSaenzdeCabezon_2014X-480p.jpg?alt=media&token=e63f04b7-80d9-40d0-a1d4-87fa1aa43bd3",
            "https://firebasestorage.googleapis.com/v0/b/padm-atv04-talks.appspot.com/o/" +
                "EduardoSaenzdeCabezon_2014X-480p_small.webm?alt=media&token=d49bc62a-724f-4261-a6a7-1fac6df8d966",
        ),
        VideoDTO(
            3,
            "What if 3D printing was 100x faster?",
            "TED2015",
            10 * 60 + 34,
            Video.parseDate("Mar 2015"),
            "Joseph DeSimone",
            "https://www.ted.com/talks/joe_desimone_what_if_3d_printing_was_25x_faster",
            "https://firebasestorage.googleapis.com/v0/b/padm-atv04-talks.appspot.com/o/" +
                "JosephDeSimone_2015-480p.jpg?alt=media&token=452775f5-a512-4af9-ad87-3082f0a4234b",
            "https://firebasestorage.googleapis.com/v0/b/padm-atv04-talks.appspot.com/o/" +
                "JosephDeSimone_2015-480p_small.webm?alt=media&token=35d65403-3fdb-4f01-83a5-ebe986df1582",
        ),
        VideoDTO(
            4,
            "Think your email's private? Think again",
            "TEDGlobal 2014",
            12 * 60 + 1,
            Video.parseDate("Oct 2014"),
            "Andy Yen",
            "https://www.ted.com/talks/andy_yen_think_your_email_s_private_think_again",
            "https://firebasestorage.googleapis.com/v0/b/padm-atv04-talks.appspot.com/o/" +
                "AndyYen_2014G-480p.jpg?alt=media&token=a79c7ea5-a721-46ad-af53-a8915a6928d1",
            "https://firebasestorage.googleapis.com/v0/b/padm-atv04-talks.appspot.com/o/" +
                "AndyYen_2014G-480p_small.webm?alt=media&token=c9d53212-dc60-461f-91e5-7fbad720da71",
        ),
        VideoDTO(
            5,
            "How virtual reality can create the ultimate empathy machine",
            "TED2015",
            10 * 60 + 16,
            Video.parseDate("Mar 2015"),
            "Chris Milk",
            "https://www.ted.com/talks/chris_milk_how_virtual_reality_can_create_the_ultimate_empathy_machine",
            "https://firebasestorage.googleapis.com/v0/b/padm-atv04-talks.appspot.com/o/" +
                "ChrisMilk_2015-480p.jpg?alt=media&token=78b01bc6-aa04-4f72-89f7-1ae90212b3a5",
            "https://firebasestorage.googleapis.com/v0/b/padm-atv04-talks.appspot.com/o/" +
                "ChrisMilk_2015-480p_small.webm?alt=media&token=4b5d85d4-19e7-4924-991c-632eebabba14",
        )
    )
}
