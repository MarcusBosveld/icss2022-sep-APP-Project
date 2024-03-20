// Generated from C:/Users/mbosv/Documents/GitHub/icss2022-sep-APP-Project/startcode/src/main/antlr4/nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ICSSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, IF=4, ELSE=5, BOX_BRACKET_OPEN=6, BOX_BRACKET_CLOSE=7, 
		TRUE=8, FALSE=9, PIXELSIZE=10, PERCENTAGE=11, SCALAR=12, COLOR=13, ID_IDENT=14, 
		CLASS_IDENT=15, LOWER_IDENT=16, CAPITAL_IDENT=17, WS=18, OPEN_BRACE=19, 
		CLOSE_BRACE=20, SEMICOLON=21, COLON=22, PLUS=23, MIN=24, MUL=25, ASSIGNMENT_OPERATOR=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "IF", "ELSE", "BOX_BRACKET_OPEN", "BOX_BRACKET_CLOSE", 
			"TRUE", "FALSE", "PIXELSIZE", "PERCENTAGE", "SCALAR", "COLOR", "ID_IDENT", 
			"CLASS_IDENT", "LOWER_IDENT", "CAPITAL_IDENT", "WS", "OPEN_BRACE", "CLOSE_BRACE", 
			"SEMICOLON", "COLON", "PLUS", "MIN", "MUL", "ASSIGNMENT_OPERATOR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'('", "')'", "'if'", "'else'", "'['", "']'", "'TRUE'", 
			"'FALSE'", null, null, null, null, null, null, null, null, null, "'{'", 
			"'}'", "';'", "':'", "'+'", "'-'", "'*'", "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "IF", "ELSE", "BOX_BRACKET_OPEN", "BOX_BRACKET_CLOSE", 
			"TRUE", "FALSE", "PIXELSIZE", "PERCENTAGE", "SCALAR", "COLOR", "ID_IDENT", 
			"CLASS_IDENT", "LOWER_IDENT", "CAPITAL_IDENT", "WS", "OPEN_BRACE", "CLOSE_BRACE", 
			"SEMICOLON", "COLON", "PLUS", "MIN", "MUL", "ASSIGNMENT_OPERATOR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ICSSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ICSS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001a\u00a0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0004\tT\b\t\u000b\t\f\tU\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0004\n\\\b\n\u000b\n\f\n]\u0001\n\u0001\n\u0001\u000b\u0004\u000b"+
		"c\b\u000b\u000b\u000b\f\u000bd\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0004\rq\b\r\u000b\r\f\rr\u0001"+
		"\u000e\u0001\u000e\u0004\u000ew\b\u000e\u000b\u000e\f\u000ex\u0001\u000f"+
		"\u0001\u000f\u0005\u000f}\b\u000f\n\u000f\f\u000f\u0080\t\u000f\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u0084\b\u0010\n\u0010\f\u0010\u0087\t\u0010"+
		"\u0001\u0011\u0004\u0011\u008a\b\u0011\u000b\u0011\f\u0011\u008b\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0000\u0000\u001a\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a\u0001\u0000\u0007\u0001"+
		"\u000009\u0002\u000009af\u0003\u0000--09az\u0001\u0000az\u0001\u0000A"+
		"Z\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u00a7\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00015\u0001"+
		"\u0000\u0000\u0000\u00037\u0001\u0000\u0000\u0000\u00059\u0001\u0000\u0000"+
		"\u0000\u0007;\u0001\u0000\u0000\u0000\t>\u0001\u0000\u0000\u0000\u000b"+
		"C\u0001\u0000\u0000\u0000\rE\u0001\u0000\u0000\u0000\u000fG\u0001\u0000"+
		"\u0000\u0000\u0011L\u0001\u0000\u0000\u0000\u0013S\u0001\u0000\u0000\u0000"+
		"\u0015[\u0001\u0000\u0000\u0000\u0017b\u0001\u0000\u0000\u0000\u0019f"+
		"\u0001\u0000\u0000\u0000\u001bn\u0001\u0000\u0000\u0000\u001dt\u0001\u0000"+
		"\u0000\u0000\u001fz\u0001\u0000\u0000\u0000!\u0081\u0001\u0000\u0000\u0000"+
		"#\u0089\u0001\u0000\u0000\u0000%\u008f\u0001\u0000\u0000\u0000\'\u0091"+
		"\u0001\u0000\u0000\u0000)\u0093\u0001\u0000\u0000\u0000+\u0095\u0001\u0000"+
		"\u0000\u0000-\u0097\u0001\u0000\u0000\u0000/\u0099\u0001\u0000\u0000\u0000"+
		"1\u009b\u0001\u0000\u0000\u00003\u009d\u0001\u0000\u0000\u000056\u0005"+
		"/\u0000\u00006\u0002\u0001\u0000\u0000\u000078\u0005(\u0000\u00008\u0004"+
		"\u0001\u0000\u0000\u00009:\u0005)\u0000\u0000:\u0006\u0001\u0000\u0000"+
		"\u0000;<\u0005i\u0000\u0000<=\u0005f\u0000\u0000=\b\u0001\u0000\u0000"+
		"\u0000>?\u0005e\u0000\u0000?@\u0005l\u0000\u0000@A\u0005s\u0000\u0000"+
		"AB\u0005e\u0000\u0000B\n\u0001\u0000\u0000\u0000CD\u0005[\u0000\u0000"+
		"D\f\u0001\u0000\u0000\u0000EF\u0005]\u0000\u0000F\u000e\u0001\u0000\u0000"+
		"\u0000GH\u0005T\u0000\u0000HI\u0005R\u0000\u0000IJ\u0005U\u0000\u0000"+
		"JK\u0005E\u0000\u0000K\u0010\u0001\u0000\u0000\u0000LM\u0005F\u0000\u0000"+
		"MN\u0005A\u0000\u0000NO\u0005L\u0000\u0000OP\u0005S\u0000\u0000PQ\u0005"+
		"E\u0000\u0000Q\u0012\u0001\u0000\u0000\u0000RT\u0007\u0000\u0000\u0000"+
		"SR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0005p\u0000"+
		"\u0000XY\u0005x\u0000\u0000Y\u0014\u0001\u0000\u0000\u0000Z\\\u0007\u0000"+
		"\u0000\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000][\u0001"+
		"\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_`\u0005%\u0000\u0000`\u0016\u0001\u0000\u0000\u0000ac\u0007\u0000\u0000"+
		"\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000e\u0018\u0001\u0000\u0000\u0000"+
		"fg\u0005#\u0000\u0000gh\u0007\u0001\u0000\u0000hi\u0007\u0001\u0000\u0000"+
		"ij\u0007\u0001\u0000\u0000jk\u0007\u0001\u0000\u0000kl\u0007\u0001\u0000"+
		"\u0000lm\u0007\u0001\u0000\u0000m\u001a\u0001\u0000\u0000\u0000np\u0005"+
		"#\u0000\u0000oq\u0007\u0002\u0000\u0000po\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000"+
		"s\u001c\u0001\u0000\u0000\u0000tv\u0005.\u0000\u0000uw\u0007\u0002\u0000"+
		"\u0000vu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xv\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000y\u001e\u0001\u0000\u0000\u0000"+
		"z~\u0007\u0003\u0000\u0000{}\u0007\u0002\u0000\u0000|{\u0001\u0000\u0000"+
		"\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f \u0001\u0000\u0000\u0000\u0080~\u0001\u0000"+
		"\u0000\u0000\u0081\u0085\u0007\u0004\u0000\u0000\u0082\u0084\u0007\u0005"+
		"\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000"+
		"\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\"\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0088\u008a\u0007\u0006\u0000\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0006\u0011\u0000\u0000\u008e$\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0005{\u0000\u0000\u0090&\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005}\u0000\u0000\u0092(\u0001\u0000\u0000\u0000\u0093\u0094\u0005;"+
		"\u0000\u0000\u0094*\u0001\u0000\u0000\u0000\u0095\u0096\u0005:\u0000\u0000"+
		"\u0096,\u0001\u0000\u0000\u0000\u0097\u0098\u0005+\u0000\u0000\u0098."+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0005-\u0000\u0000\u009a0\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0005*\u0000\u0000\u009c2\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0005:\u0000\u0000\u009e\u009f\u0005=\u0000\u0000\u009f4"+
		"\u0001\u0000\u0000\u0000\t\u0000U]drx~\u0085\u008b\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}