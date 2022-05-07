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
            "https://firebasestorage.googleapis.com/v0/b/atv04-talks.appspot.com/" +
                "o/NathalieCabrol_2015-480p.jpg?alt=media&token=3df86d5d-c85c-43db-ae15-2db796daa4fb",
            "https://firebasestorage.googleapis.com/v0/b/atv04-talks.appspot.com/" +
                "o/2015-nathalie-cabrol-011-5000k.webm?alt=media&token=7884060e-71be-432c-95b7-021c758dd8af",
        ),
        VideoDTO(
            2,
            "Math is forever",
            "TEDxRiodelaPlata",
            9 * 60 + 28,
            Video.parseDate("Oct 2014"),
            "Eduardo Sáenz de Cabezón",
            "https://www.ted.com/talks/eduardo_saenz_de_cabezon_math_is_forever",
            "https://firebasestorage.googleapis.com/v0/b/atv04-talks.appspot.com/" +
                "o/EduardoSaenzdeCabezon_2014X-480p.jpg?alt=media&token=40e6c8e9-98c6-4a31-bb91-161d1edc96f9",
            "https://firebasestorage.googleapis.com/v0/b/atv04-talks.appspot.com/" +
                "o/2014-eduardo-saenz-de-cabezon-002-5000k.webm?" +
                "alt=media&token=0cf4c58a-3339-4695-b444-f4438f568f86",
        ),
        VideoDTO(
            3,
            "What if 3D printing was 100x faster?",
            "TED2015",
            10 * 60 + 34,
            Video.parseDate("Mar 2015"),
            "Joseph DeSimone",
            "https://www.ted.com/talks/joe_desimone_what_if_3d_printing_was_25x_faster",
            "https://firebasestorage.googleapis.com/v0/b/atv04-talks.appspot.com/" +
                "o/JosephDeSimone_2015-480p.jpg?alt=media&token=8fc2c5b9-0a8a-46b3-b4e6-b743edd3b6de",
            "https://firebasestorage.googleapis.com/v0/b/atv04-talks.appspot.com/" +
                "o/2015-joseph-desimone-006-5000k.webm?alt=media&token=a26bcf52-1b4d-4e3d-a9b6-eb0e3f51cae3",
        ),
        VideoDTO(
            4,
            "Think your email's private? Think again",
            "TEDGlobal 2014",
            12 * 60 + 1,
            Video.parseDate("Oct 2014"),
            "Andy Yen",
            "https://www.ted.com/talks/andy_yen_think_your_email_s_private_think_again",
            "https://firebasestorage.googleapis.com/v0/b/atv04-talks.appspot.com/" +
                "o/AndyYen_2014G-480p.jpg?alt=media&token=b6d123ba-b4a2-44e7-9169-88793f978eab",
            "https://firebasestorage.googleapis.com/v0/b/atv04-talks.appspot.com/" +
                "o/2014-andy-yen-009-5000k.webm?alt=media&token=4faa537d-7c8e-4cf2-a8e7-48b8f73fa76c",
        ),
        VideoDTO(
            5,
            "How virtual reality can create the ultimate empathy machine",
            "TED2015",
            10 * 60 + 16,
            Video.parseDate("Mar 2015"),
            "Chris Milk",
            "https://www.ted.com/talks/chris_milk_how_virtual_reality_can_create_the_ultimate_empathy_machine",
            "https://firebasestorage.googleapis.com/v0/b/atv04-talks.appspot.com/" +
                "o/ChrisMilk_2015-480p.jpg?alt=media&token=dec395d4-b88e-46c3-b673-e5fbd6715ec2",
            "https://firebasestorage.googleapis.com/v0/b/atv04-talks.appspot.com/" +
                "o/2015-chris-milk-011-5000k.webm?alt=media&token=2738dc1e-c9f6-4927-982f-8910ac857e14",
        )
    )
}
