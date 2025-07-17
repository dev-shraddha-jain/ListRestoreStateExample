package com.groot.listrestorestateexample.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groot.listrestorestateexample.dto.ListLoadingState
import com.groot.listrestorestateexample.dto.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuotesViewModel : ViewModel() {
    val listLoadingState = MutableStateFlow<ListLoadingState>(ListLoadingState.IS_LOADING)
    val quoteList = MutableStateFlow<List<Quote>?>(null)


    init {
        initList()
    }

    fun initList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val quotes = listOf(
                    Quote(1, "Stay hungry, stay foolish.", "Steve Jobs"),
                    Quote(2, "Simplicity is the ultimate sophistication.", "Leonardo da Vinci"),
                    Quote(3, "Do not go where the path may lead, go instead where there is no path and leave a trail.", "Ralph Waldo Emerson"),
                    Quote(4, "In the middle of difficulty lies opportunity.", "Albert Einstein"),
                    Quote(5, "Whether you think you can, or you think you can't – you're right.", "Henry Ford"),
                    Quote(6, "Life is what happens when you're busy making other plans.", "John Lennon"),
                    Quote(7, "The greatest glory in living lies not in never falling, but in rising every time we fall.", "Nelson Mandela"),
                    Quote(8, "The way to get started is to quit talking and begin doing.", "Walt Disney"),
                    Quote(9, "If life were predictable it would cease to be life, and be without flavor.", "Eleanor Roosevelt"),
                    Quote(10, "Spread love everywhere you go.", "Mother Teresa"),
                    Quote(11, "Don't judge each day by the harvest you reap but by the seeds that you plant.", "Robert Louis Stevenson"),
                    Quote(12, "The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"),
                    Quote(13, "Tell me and I forget. Teach me and I remember. Involve me and I learn.", "Benjamin Franklin"),
                    Quote(14, "The best and most beautiful things in the world cannot be seen or even touched—they must be felt with the heart.", "Helen Keller"),
                    Quote(15, "It is during our darkest moments that we must focus to see the light.", "Aristotle"),
                    Quote(16, "You only live once, but if you do it right, once is enough.", "Mae West"),
                    Quote(17, "In three words I can sum up everything I've learned about life: it goes on.", "Robert Frost"),
                    Quote(18, "If you want to live a happy life, tie it to a goal, not to people or things.", "Albert Einstein"),
                    Quote(19, "Never let the fear of striking out keep you from playing the game.", "Babe Ruth"),
                    Quote(20, "Money and success don’t change people; they merely amplify what is already there.", "Will Smith"),
                    Quote(21, "Your time is limited, so don’t waste it living someone else’s life.", "Steve Jobs"),
                    Quote(22, "Not how long, but how well you have lived is the main thing.", "Seneca"),
                    Quote(23, "Don't watch the clock; do what it does. Keep going.", "Sam Levenson"),
                    Quote(24, "Keep your face always toward the sunshine—and shadows will fall behind you.", "Walt Whitman"),
                    Quote(25, "Success usually comes to those who are too busy to be looking for it.", "Henry David Thoreau"),
                    Quote(26, "Opportunities don't happen, you create them.", "Chris Grosser"),
                    Quote(27, "Try not to become a man of success, but rather try to become a man of value.", "Albert Einstein"),
                    Quote(28, "I find that the harder I work, the more luck I seem to have.", "Thomas Jefferson"),
                    Quote(29, "Don’t be afraid to give up the good to go for the great.", "John D. Rockefeller"),
                    Quote(30, "I failed my way to success.", "Thomas Edison"),
                    Quote(31, "The only way to do great work is to love what you do.", "Steve Jobs"),
                    Quote(32, "The mind is everything. What you think you become.", "Buddha"),
                    Quote(33, "An unexamined life is not worth living.", "Socrates"),
                    Quote(34, "Eighty percent of success is showing up.", "Woody Allen"),
                    Quote(35, "Your time is limited, don't waste it living someone else's life.", "Steve Jobs"),
                    Quote(36, "Winning isn’t everything, but wanting to win is.", "Vince Lombardi"),
                    Quote(37, "I have not failed. I've just found 10,000 ways that won't work.", "Thomas Edison"),
                    Quote(38, "If you love life, don’t waste time, for time is what life is made up of.", "Bruce Lee"),
                    Quote(39, "Success is not in what you have, but who you are.", "Bo Bennett"),
                    Quote(40, "Success is walking from failure to failure with no loss of enthusiasm.", "Winston Churchill"),
                    Quote(41, "The purpose of our lives is to be happy.", "Dalai Lama"),
                    Quote(42, "Life is short, and it is here to be lived.", "Kate Winslet"),
                    Quote(43, "To live is the rarest thing in the world. Most people exist, that is all.", "Oscar Wilde"),
                    Quote(44, "Get busy living or get busy dying.", "Stephen King"),
                    Quote(45, "You have within you right now, everything you need to deal with whatever the world can throw at you.", "Brian Tracy"),
                    Quote(46, "Believe you can and you’re halfway there.", "Theodore Roosevelt"),
                    Quote(47, "Don’t count the days, make the days count.", "Muhammad Ali"),
                    Quote(48, "The only impossible journey is the one you never begin.", "Tony Robbins"),
                    Quote(49, "Act as if what you do makes a difference. It does.", "William James"),
                    Quote(50, "Success is not how high you have climbed, but how you make a positive difference to the world.", "Roy T. Bennett"),
                    Quote(51, "Hardships often prepare ordinary people for an extraordinary destiny.", "C.S. Lewis"),
                    Quote(52, "The only limit to our realization of tomorrow will be our doubts of today.", "Franklin D. Roosevelt"),
                    Quote(53, "Do what you can, with what you have, where you are.", "Theodore Roosevelt"),
                    Quote(54, "Impossible is just an opinion.", "Paulo Coelho"),
                    Quote(55, "Perfection is not attainable, but if we chase perfection we can catch excellence.", "Vince Lombardi"),
                    Quote(56, "Everything you’ve ever wanted is on the other side of fear.", "George Addair"),
                    Quote(57, "Success seems to be connected with action. Successful people keep moving.", "Conrad Hilton"),
                    Quote(58, "Don't wait for opportunity. Create it.", "Unknown"),
                    Quote(59, "Success is the sum of small efforts, repeated day-in and day-out.", "Robert Collier"),
                    Quote(60, "What we achieve inwardly will change outer reality.", "Plutarch"),
                    Quote(61, "Dream big and dare to fail.", "Norman Vaughan"),
                    Quote(62, "You are never too old to set another goal or to dream a new dream.", "C.S. Lewis"),
                    Quote(63, "Believe in yourself and all that you are.", "Christian D. Larson"),
                    Quote(64, "Don’t be pushed around by the fears in your mind. Be led by the dreams in your heart.", "Roy T. Bennett"),
                    Quote(65, "Dreaming, after all, is a form of planning.", "Gloria Steinem"),
                    Quote(66, "Success is liking yourself, liking what you do, and liking how you do it.", "Maya Angelou"),
                    Quote(67, "What lies behind us and what lies before us are tiny matters compared to what lies within us.", "Ralph Waldo Emerson"),
                    Quote(68, "Everything has beauty, but not everyone can see.", "Confucius"),
                    Quote(69, "You don’t find the happy life. You make it.", "Camilla Eyring Kimball"),
                    Quote(70, "The best revenge is massive success.", "Frank Sinatra"),
                    Quote(71, "Challenges are what make life interesting; overcoming them is what makes life meaningful.", "Joshua J. Marine"),
                    Quote(72, "Try to be a rainbow in someone’s cloud.", "Maya Angelou"),
                    Quote(73, "An investment in knowledge pays the best interest.", "Benjamin Franklin"),
                    Quote(74, "It always seems impossible until it’s done.", "Nelson Mandela"),
                    Quote(75, "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.", "Ralph Waldo Emerson"),
                    Quote(76, "Good things come to people who wait, but better things come to those who go out and get them.", "Anonymous"),
                    Quote(77, "Don’t limit your challenges. Challenge your limits.", "Anonymous"),
                    Quote(78, "Push yourself, because no one else is going to do it for you.", "Anonymous"),
                    Quote(79, "Great things never come from comfort zones.", "Anonymous"),
                    Quote(80, "Dream it. Wish it. Do it.", "Anonymous"),
                    Quote(81, "Success doesn’t just find you. You have to go out and get it.", "Anonymous"),
                    Quote(82, "The harder you work for something, the greater you’ll feel when you achieve it.", "Anonymous"),
                    Quote(83, "Dream bigger. Do bigger.", "Anonymous"),
                    Quote(84, "Don’t stop when you’re tired. Stop when you’re done.", "Anonymous"),
                    Quote(85, "Wake up with determination. Go to bed with satisfaction.", "Anonymous"),
                    Quote(86, "Do something today that your future self will thank you for.", "Anonymous"),
                    Quote(87, "Little things make big days.", "Anonymous"),
                    Quote(88, "It’s going to be hard, but hard does not mean impossible.", "Anonymous"),
                    Quote(89, "Don’t wait for opportunity. Create it.", "Anonymous"),
                    Quote(90, "Sometimes we’re tested not to show our weaknesses, but to discover our strengths.", "Anonymous"),
                    Quote(91, "The key to success is to focus on goals, not obstacles.", "Anonymous"),
                    Quote(92, "Dream it. Believe it. Build it.", "Anonymous"),
                    Quote(93, "Don’t downgrade your dream just to fit your reality. Upgrade your conviction to match your destiny.", "Anonymous"),
                    Quote(94, "You don’t have to be great to start, but you have to start to be great.", "Zig Ziglar"),
                    Quote(95, "Great things take time.", "Anonymous"),
                    Quote(96, "Stay positive. Work hard. Make it happen.", "Anonymous"),
                    Quote(97, "Do what is right, not what is easy nor what is popular.", "Roy T. Bennett"),
                    Quote(98, "Success is not just making money. Success is happiness.", "Anonymous"),
                    Quote(99, "The secret of getting ahead is getting started.", "Mark Twain"),
                    Quote(100, "What you get by achieving your goals is not as important as what you become by achieving your goals.", "Zig Ziglar")
                )

                quoteList.value = quotes
                listLoadingState.value = ListLoadingState.COMPLETED
            }
        }
    }
}