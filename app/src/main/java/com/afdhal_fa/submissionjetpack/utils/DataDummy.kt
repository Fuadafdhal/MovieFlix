package com.afdhal_fa.submissionjetpack.utils

import com.afdhal_fa.submissionjetpack.data.source.remote.response.MovieResponse
import com.afdhal_fa.submissionjetpack.domain.model.Movie


object DataDummy {
    fun generateDummyMovie(): List<Movie> {
        val mMoviesEntity = ArrayList<Movie>()

        mMoviesEntity.add(
            Movie(
                "mMovie1", "A Star Is Born (2018)",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "@drawable/poster_a_start_is_born", "English", "2h 16m", "Drama, Romance, Music", false
            )
        )

        mMoviesEntity.add(
            Movie(
                "mMovie2", "Alita: Battle Angel (2019)",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "@drawable/poster_alita", "English", "2h 2m", "Action, Science Fiction, Thriller, Adventure", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mMovie3", "Aquaman (2018)",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "@drawable/poster_aquaman", "English", "2h 24m", "Action, Adventure,Fantasy", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mMovie4", "Bohemian Rhapsody (2018",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock & roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "@drawable/poster_bohemian", "English", "2h 15m", "Drama,Music", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mMovie5", "Cold Pursuit (2019)",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "@drawable/poster_cold_persuit", "English", "2h 59m", "Action", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mMovie6", "Creed II (2018)",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "@drawable/poster_creed", "English", "2h 10m", "Drama", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mMovie7", "Fantastic Beasts: The Crimes of Grindelwald (2018)",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "@drawable/poster_crimes", "English", "2h 14m", "Adventure, Fantasy, Family", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mMovie8", "Glass (2019)",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "@drawable/poster_glass", "English", "2h 9m", "Thriller, Drama, Science Fiction", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mMovie9", "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "@drawable/poster_how_to_train", "English", "2h 44m", "Animation, Family, Adventure", false
            )
        )


        mMoviesEntity.add(
            Movie(
                "mMovie10", "Avengers: Infinity War (2018)",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "@drawable/poster_infinity_war", "English", "2h 29m", "Adventure, Action, Science Fiction", false
            )
        )
        return mMoviesEntity
    }

    fun generateDummyTVShow(): List<Movie> {
        val mMoviesEntity = ArrayList<Movie>()

        mMoviesEntity.add(
            Movie(
                "mTvShow1", "Arrow (2012)",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "@drawable/poster_arrow", "English", "42m", "Crime, Drama, Mystery, Action, Adventure", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mTvShow2", "Doom Patrol (2019",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "@drawable/poster_doom_patrol", "English", "60m", "Sci-Fi, Fantasy, Action, Adventure", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mTvShow3", "Dragon Ball (1986)",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "@drawable/poster_dragon_ball", "Japanese", "25m", "Comedy, Sci-Fi, Fantasy, Animation, Action, Adventure", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mTvShow4", "Fairy Tail (2009",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "@drawable/poster_fairytail", "Japanese", "25m", "Action, Adventure, Animation, Comedy, Sci-Fi, Fantasy", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mTvShow5", "Family Guy (1999",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "@drawable/poster_family_guy", "English", "22m", "Animation, Comedy", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mTvShow6", "The Flash (2014)",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become… The Flash.",
                "@drawable/poster_flash", "English", "44 m", "Drama, Sci-Fi, Fantasy", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mTvShow7", "Gotham (2014)",
                "Before there was Batman, there was GOTHAM.\nEveryone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "@drawable/poster_gotham", "English", "22 m", "Drama, Fantasy, Crime", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mTvShow8", "Grey's Anatomy (2005)",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "@drawable/poster_grey_anatomy", "English", "43 m", "Drama", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mTvShow9", "Marvel's Iron Fist (2017)",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "@drawable/poster_iron_fist", "English", "43 m", "Action, Adventure, Crime, Drama, Sci-Fi, Fantasy", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mTvShow10", "Naruto Shippūden (2007)",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "@drawable/poster_naruto_shipudden", "English", "55 m", "Animation, Comedy, Drama", false
            )
        )
        mMoviesEntity.add(
            Movie(
                "mTvShow11", "NCIS (2003)",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "@drawable/poster_ncis", "Japanese", "25 m", "Action, Adventure, Crime, Drama", false
            )
        )

        return mMoviesEntity
    }

    fun generateRemoteDummyMovie(): List<MovieResponse> {
        val mMoviesEntity = ArrayList<MovieResponse>()

        mMoviesEntity.add(
            MovieResponse(
                "mMovie1", "A Star Is Born (2018)", "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.", "@drawable/poster_a_start_is_born", "English", "2h 16m", "Drama, Romance, Music"
            )
        )

        mMoviesEntity.add(
            MovieResponse(
                "mMovie2", "Alita: Battle Angel (2019)", "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.", "@drawable/poster_alita", "English", "2h 2m", "Action, Science Fiction, Thriller, Adventure"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mMovie3", "Aquaman (2018)", "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.", "@drawable/poster_aquaman", "English", "2h 24m", "Action, Adventure,Fantasy"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mMovie4", "Bohemian Rhapsody (2018", "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock & roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.", "@drawable/poster_bohemian", "English", "2h 15m", "Drama,Music"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mMovie5", "Cold Pursuit (2019)", "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.", "@drawable/poster_cold_persuit", "English", "2h 59m", "Action"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mMovie6", "Creed II (2018)", "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.", "@drawable/poster_creed", "English", "2h 10m", "Drama"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mMovie7", "Fantastic Beasts: The Crimes of Grindelwald (2018)", "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.", "@drawable/poster_crimes", "English", "2h 14m", "Adventure, Fantasy, Family"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mMovie8", "Glass (2019)", "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.", "@drawable/poster_glass", "English", "2h 9m", "Thriller, Drama, Science Fiction"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mMovie9", "How to Train Your Dragon: The Hidden World", "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.", "@drawable/poster_how_to_train", "English", "2h 44m", "Animation, Family, Adventure"
            )
        )


        mMoviesEntity.add(
            MovieResponse(
                "mMovie10", "Avengers: Infinity War (2018)", "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.", "@drawable/poster_infinity_war", "English", "2h 29m", "Adventure, Action, Science Fiction"
            )
        )
        return mMoviesEntity
    }

    fun generateRemoteDummyTVShow(): List<MovieResponse> {
        val mMoviesEntity = ArrayList<MovieResponse>()

        mMoviesEntity.add(
            MovieResponse(
                "mTvShow1", "Arrow (2012)", "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.", "@drawable/poster_arrow", "English", "42m", "Crime, Drama, Mystery, Action, Adventure"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mTvShow2", "Doom Patrol (2019", "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.", "@drawable/poster_doom_patrol", "English", "60m", "Sci-Fi, Fantasy, Action, Adventure"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mTvShow3", "Dragon Ball (1986)", "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.", "@drawable/poster_dragon_ball", "Japanese", "25m", "Comedy, Sci-Fi, Fantasy, Animation, Action, Adventure"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mTvShow4", "Fairy Tail (2009", "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.", "@drawable/poster_fairytail", "Japanese", "25m", "Action, Adventure, Animation, Comedy, Sci-Fi, Fantasy"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mTvShow5", "Family Guy (1999", "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.", "@drawable/poster_family_guy", "English", "22m", "Animation, Comedy"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mTvShow6", "The Flash (2014)", "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become… The Flash.", "@drawable/poster_flash", "English", "44 m", "Drama, Sci-Fi, Fantasy"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mTvShow7", "Gotham (2014)", "Before there was Batman, there was GOTHAM.\nEveryone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?", "@drawable/poster_gotham", "English", "22 m", "Drama, Fantasy, Crime"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mTvShow8", "Grey's Anatomy (2005)", "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.", "@drawable/poster_grey_anatomy", "English", "43 m", "Drama"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mTvShow9", "Marvel's Iron Fist (2017)", "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.", "@drawable/poster_iron_fist", "English", "43 m", "Action, Adventure, Crime, Drama, Sci-Fi, Fantasy"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mTvShow10", "Naruto Shippūden (2007)",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "@drawable/poster_naruto_shipudden", "English", "55 m", "Animation, Comedy, Drama"
            )
        )
        mMoviesEntity.add(
            MovieResponse(
                "mTvShow11", "NCIS (2003)",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "@drawable/poster_ncis", "Japanese", "25 m", "Action, Adventure, Crime, Drama"
            )
        )

        return mMoviesEntity
    }


    //    fun generateRemoteDummyContent(moduleId: String): ContentResponse = ContentResponse(moduleId, "This is a dummy content")
    //
    //    fun generateDummyCourseWithModules(course: CourseEntity, bookmarked: Boolean): CourseWithModule {
    //        course.bookmarked = bookmarked
    //        return CourseWithModule(course, generateDummyModules(course.courseId))
    //    }

    //    fun generateDummyContent(moduleId: String): ContentEntity = ContentEntity("This is a dummy content")

    fun generateDummyMovieWithId(): Movie {
        return generateDummyMovie()[0]
    }

    fun generateDummyTVShowWithId(): Movie {
        return generateDummyTVShow()[0]
    }
}