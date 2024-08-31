/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.ForceIntentAction;
/*    */ import Koishi.cards.AbstractIntentChangingCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class PhilosophyOfTheDespised
/*    */   extends AbstractIntentChangingCard {
/* 20 */   public static final String ID = KoishiMod.makeID(PhilosophyOfTheDespised.class.getSimpleName());
/* 21 */   public static final String IMG = KoishiMod.makeCardPath("PhilosophyOfTheDespised.png");
/*    */   
/* 23 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 24 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ALL_ENEMY;
/* 25 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 26 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   public PhilosophyOfTheDespised() {
/* 31 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET, AbstractIntentChangingCard.IntentTypes.ATTACK);
/* 32 */     AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/* 33 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster mo) {
/* 38 */     KoishiMod.runAnimation("spellB");
/* 39 */     Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 40 */     while (iterator.hasNext()) {
/* 41 */       AbstractMonster m = iterator.next();
/* 42 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ForceIntentAction(p, m, this.intentType));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void triggerWhenDrawn() {
/* 49 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)AbstractDungeon.player, 1));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 55 */     return 12.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 61 */     if (!this.upgraded) {
/* 62 */       upgradeName();
/* 63 */       this.exhaust = false;
/* 64 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 65 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/PhilosophyOfTheDespised.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */